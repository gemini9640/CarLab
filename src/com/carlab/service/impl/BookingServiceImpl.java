package com.carlab.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlab.common.ServerResponse;
import com.carlab.db.Booking;
import com.carlab.db.BookingItem;
import com.carlab.db.Product;
import com.carlab.db.Customer;
import com.carlab.db.Staff;
import com.carlab.db.UserCar;
import com.carlab.enums.BookingStatus;
import com.carlab.enums.ResponseCode;
import com.carlab.mapper.BookingItemMapper;
import com.carlab.mapper.BookingMapper;
import com.carlab.mapper.ProductMapper;
import com.carlab.mapper.UserCarMapper;
import com.carlab.mapper.UserCarPictureMapper;
import com.carlab.service.IBookingService;
import com.carlab.utils.CarlabHelper;
import com.carlab.utils.DateUtils;
import com.carlab.utils.StringUtils;
import com.carlab.vo.BookingCalenderDate;
import com.carlab.vo.BookingCalenderMonth;
import com.carlab.vo.BookingDetailVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.carlab.db.vo.BookingBriefVo;
import com.carlab.db.vo.SalesVo;

@Service("iBookingService")
public class BookingServiceImpl implements IBookingService {
	
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private BookingMapper bookingMapper;
	@Autowired
	private BookingItemMapper bookingItemMapper;
	@Autowired
	private UserCarMapper userCarMapper;
	@Autowired
	private UserCarPictureMapper userCarPictureMapper;
	
	public ServerResponse<Booking> createBooking(Customer customer, String shipping, List<Integer> bookingItemIds, Date bookingTime) {
		Date createTime = new Date();
		Long bookingNo = CarlabHelper.generateOrderNo();
		Booking booking = CarlabHelper.createBooking(bookingNo, customer.getId(), bookingTime, createTime, shipping);
		bookingMapper.insert(booking);
		for (Integer bookingItemId : bookingItemIds) {
			BookingItem bookingItem = CarlabHelper.updateBookingItemForNewBooking(bookingItemId, bookingNo);
			bookingItemMapper.updateByPrimaryKeySelective(bookingItem);
		}
		return ServerResponse.createBySuccess("booking success", booking);
	}
	
	public ServerResponse<BookingItem> createBookingItem(Customer customer, Integer categoryId, Integer userCarId, String carInfo, String remark) {
		int updateCount = 0;
		UserCar userCar = null;
		//客户输入了车辆信息
		if(StringUtils.isNotEmpty(carInfo)) {
			if(userCarId == null) {
				//第一次创建车辆信息
				userCar = CarlabHelper.assembleUserCarForNew(customer.getId(), carInfo);
				userCarId = userCarMapper.insert(userCar);
				updateCount = 1;
			} else {
				//更新已有的车辆记录的信息
				userCar = CarlabHelper.assembleUserCarForUpdate(userCarId, customer.getId(), carInfo);
				updateCount = userCarMapper.updateCarInfoByKeyAndUserId(userCar);
			} 
		}
		if(userCar != null && updateCount < 1) 
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ILLIGAL_ARGUMENT.getCode(), "参数错误更新失败:"+userCarId+" "+customer.getId());
		Date createTime = new Date();
		BookingItem bookingItem = CarlabHelper.assembleBookingItem(customer.getId(), categoryId, userCarId, createTime, remark);
		bookingItemMapper.insert(bookingItem);
		return ServerResponse.createBySuccess(bookingItem);
	}
	
	public ServerResponse<BookingItem> confirmBookingItem(Staff staff, Integer id, Integer productId, Integer userCarId, BigDecimal otherCharge, String otherChargeInfo, Date bookingTime) {
		BookingItem bookingItem = bookingItemMapper.selectByPrimaryKey(id);
		if(bookingItem == null)
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ILLIGAL_ARGUMENT.getCode(), ResponseCode.ILLIGAL_ARGUMENT.getDesc());
		if(bookingItem.getBookingNo() == null)
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ILLIGAL_ARGUMENT.getCode(), "booking is not yet submit");
		Product product = productMapper.selectByPrimaryKey(productId);
		if(product == null)
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ILLIGAL_ARGUMENT.getCode(), ResponseCode.ILLIGAL_ARGUMENT.getDesc());
		bookingItem = CarlabHelper.assembleConfirmBookingItem(bookingItem, product, userCarId, otherCharge, otherChargeInfo, bookingTime);
		bookingItemMapper.updateByPrimaryKeySelective(bookingItem);
		//log
		return ServerResponse.createBySuccess(bookingItem);
	}
	
	public ServerResponse<BookingItem> doneBookingItem(Staff staff, Integer id) {
		BookingItem bookingItem = bookingItemMapper.selectByPrimaryKey(id);
		if(bookingItem == null)
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ILLIGAL_ARGUMENT.getCode(), ResponseCode.ILLIGAL_ARGUMENT.getDesc());
		if(bookingItem.getStatus().intValue() < BookingStatus.ONGOING.getCode())
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ILLIGAL_ARGUMENT.getCode(), "booking is not ready for done");
		if(bookingItem.getStatus().intValue() > BookingStatus.ONGOING.getCode())
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ILLIGAL_ARGUMENT.getCode(), "booking is done or cancelled, try the other one");
		bookingItem = CarlabHelper.assembleDoneBookingItem(bookingItem);
		bookingItemMapper.updateByPrimaryKeySelective(bookingItem);
		//log
		return ServerResponse.createBySuccess(bookingItem);
	}
	
	public ServerResponse<BookingDetailVo> confirmBooking(Staff staff, Integer bookingId, List<Integer> bookingItemIds, Integer outdoorCharge) {
		List<BookingItem> items = bookingItemMapper.selectByPrimaryKeys(bookingItemIds);
		BigDecimal payment = CarlabHelper.sumConfirmmedBookingItemPayment(items);
		if(payment == null)
			ServerResponse.createByErrorMsg("includs not confirm item(s)");
		Booking booking = bookingMapper.selectByPrimaryKey(bookingId);
		CarlabHelper.assembleBookingForConfirm(booking, outdoorCharge, payment);
		bookingMapper.updateByPrimaryKeySelective(booking);
		//log
		return ServerResponse.createBySuccess(CarlabHelper.assembleBookingDetailVO(booking, items));
	}
	
	public ServerResponse<BookingDetailVo> doneBooking(Staff staff, Integer bookingId, List<Integer> bookingItemIds) {
		List<BookingItem> items = bookingItemMapper.selectByPrimaryKeys(bookingItemIds);
		if(CarlabHelper.isAllBookingItemDone(items))
			ServerResponse.createByErrorMsg("one or more item(s) not done yet");
		Booking booking = bookingMapper.selectByPrimaryKey(bookingId);
		Booking doneBooking = CarlabHelper.assembleBookingForDone(booking);
		bookingMapper.updateByPrimaryKeySelective(doneBooking);
		//log
		return ServerResponse.createBySuccess(CarlabHelper.assembleBookingDetailVO(doneBooking, items));
	}
	
//	cencalBookingItme
//	shippingBookingItme
//	finishBookingItme
	
	public ServerResponse<BookingCalenderMonth> queryBookingCalenderByMonth(Date date) {
		Date start = DateUtils.getMonthFirstTime(date);
		Date end = DateUtils.getNextMonthFirstTime(date);
		List<BookingItem> items = bookingItemMapper.selectByDate(start, end);
		Map<Integer, BookingCalenderDate> calenderDateMap = new LinkedHashMap<Integer, BookingCalenderDate>();
		for (BookingItem bookingItem : items) {
			Date bookingTime = bookingItem.getBookingTime();
			Integer bookingDate = Integer.valueOf(DateUtils.getDay(bookingTime));
			BookingCalenderDate calenderDate = calenderDateMap.get(bookingDate);
			List<BookingItem> dateItems = null;
			if(calenderDate == null) {
				dateItems = new ArrayList<BookingItem>();
				calenderDate = new BookingCalenderDate();
				calenderDate.setDate(bookingDate);
				calenderDate.setBookingItems(dateItems);
				calenderDateMap.put(bookingDate, calenderDate);
			} else 
				dateItems = calenderDate.getBookingItems();
			dateItems.add(bookingItem);
		}
		return ServerResponse.createBySuccess(new BookingCalenderMonth(Integer.valueOf(DateUtils.getMonth(date)), calenderDateMap)); 
	}
	
	public ServerResponse<BookingCalenderDate> queryBookingCalenderByDate(Date date) {
		Date start = DateUtils.getToday(date);
		Date end = DateUtils.getTomorrow(date);
		List<BookingItem> items = bookingItemMapper.selectByDate(start, end);
		BookingCalenderDate bookingCalenderDate = new BookingCalenderDate(); 
		Integer bookingDate = Integer.valueOf(DateUtils.getDay(date));
		bookingCalenderDate.setDate(bookingDate);
		bookingCalenderDate.setBookingItems(items);
		return ServerResponse.createBySuccess(bookingCalenderDate);
	} 
	
	public ServerResponse<PageInfo<SalesVo>> querySales(Date start, Date end, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<SalesVo> sales = bookingItemMapper.selectSalesSummarized(start, end);
		return ServerResponse.createBySuccess(new PageInfo<SalesVo>(sales));
	} 
	
	public ServerResponse<PageInfo<BookingItem>> queryBookingItems(Date start, Date end, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<BookingItem> items = bookingItemMapper.selectByDate(start, end);
		return ServerResponse.createBySuccess(new PageInfo<BookingItem>(items));
	} 
	
	public ServerResponse<PageInfo<BookingBriefVo>> queryBookingBrief(Date start, Date end, Integer status, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<BookingBriefVo> items = bookingItemMapper.selectBookingItemBrief(start, end, status);
		return ServerResponse.createBySuccess(new PageInfo<BookingBriefVo>(items));
	}
	
	public ServerResponse<PageInfo<BookingBriefVo>> queryBookingBriefByStatus(Integer status, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<BookingBriefVo> items = bookingItemMapper.selectBookingItemBriefByStatus(status);
		return ServerResponse.createBySuccess(new PageInfo<BookingBriefVo>(items));
	}
}
