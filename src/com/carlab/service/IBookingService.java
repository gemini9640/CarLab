package com.carlab.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.carlab.common.ServerResponse;
import com.carlab.db.Booking;
import com.carlab.db.BookingItem;
import com.carlab.db.Customer;
import com.carlab.db.Staff;
import com.carlab.db.vo.BookingBriefVo;
import com.carlab.db.vo.SalesVo;
import com.carlab.vo.BookingCalenderDate;
import com.carlab.vo.BookingCalenderMonth;
import com.carlab.vo.BookingDetailVo;
import com.github.pagehelper.PageInfo;

public interface IBookingService {
	public ServerResponse<Booking> createBooking(Customer customer, String shipping, List<Integer> bookingItemIds, Date bookingTime);
	
	public ServerResponse<BookingItem> createBookingItem(Customer customer, Integer categoryId, Integer userCarId, String carInfo, String remark);
	
	public ServerResponse<BookingItem> confirmBookingItem(Staff staff, Integer id, Integer productId, Integer userCarId, BigDecimal otherCharge, String otherChargeInfo, Date bookingTime);
	
	public ServerResponse<BookingItem> doneBookingItem(Staff staff, Integer id);
	
	public ServerResponse<BookingDetailVo> confirmBooking(Staff staff, Integer bookingId, List<Integer> bookingItemIds, Integer outdoorCharge);
	
	public ServerResponse<BookingDetailVo> doneBooking(Staff staff, Integer bookingId, List<Integer> bookingItemIds);
	
	public ServerResponse<BookingCalenderMonth> queryBookingCalenderByMonth(Date date);
	
	public ServerResponse<BookingCalenderDate> queryBookingCalenderByDate(Date date);
	
	public ServerResponse<PageInfo<SalesVo>> querySales(Date start, Date end, Integer pageNum, Integer pageSize);
	
	public ServerResponse<PageInfo<BookingItem>> queryBookingItems(Date start, Date end, Integer pageNum, Integer pageSize);
	
	public ServerResponse<PageInfo<BookingBriefVo>> queryBookingBrief(Date start, Date end, Integer status, Integer pageNum, Integer pageSize);
	
	public ServerResponse<PageInfo<BookingBriefVo>> queryBookingBriefByStatus(Integer status, Integer pageNum, Integer pageSize);
//	1.Order No
//	3. Date Picker
//	4. Time(Choose by session)
//	5. Merchant(Dropdown)
//	6. Services(Dropdown
//	public ServerResponse addEvent(Staff staff);
}
