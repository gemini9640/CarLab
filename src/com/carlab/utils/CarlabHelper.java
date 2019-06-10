package com.carlab.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.carlab.common.Constants.Flag;
import com.carlab.db.Booking;
import com.carlab.db.BookingItem;
import com.carlab.db.Customer;
import com.carlab.db.Merchant;
import com.carlab.db.Product;
import com.carlab.db.Staff;
import com.carlab.db.UserCar;
import com.carlab.db.UserCarPicture;
import com.carlab.enums.BookingStatus;
import com.carlab.vo.BookingDetailVo;
import com.carlab.vo.UserCarVo;

public class CarlabHelper {
	
	public static Merchant assembleMerchant4ChangePassword(String id, String password) {
		Merchant merchant = new Merchant();
		merchant.setId(id);
		merchant.setPassword(MD5Util.MD5EncodeUtf8(password));
		return merchant;
	} 
	
	public static Staff assembleStaff4ChangePassword(String id, String password) {
		Staff staff = new Staff();
		staff.setId(id);
		staff.setPassword(MD5Util.MD5EncodeUtf8(password));
		return staff;
	} 
	
	public static UserCarVo assembleUserCarVo(UserCar car, List<UserCarPicture> pictures) {
		UserCarVo vo = new UserCarVo();
		vo.setCarId(car.getId().toString());
		vo.setCarInfo(car.getCarInfo());
		List<String> paths = new ArrayList<String>();
		for (UserCarPicture userCarPicture : pictures) 
			paths.add(userCarPicture.getPath());
		vo.setPicturePaths(paths);
		return vo;
	}
	
	public static String encriptPassword(String password) {
		return MD5Util.MD5EncodeUtf8(password);
	}
	
	public static Customer assembleCustomer4ChangePassword(String id, String password) {
		Customer customer = new Customer();
		customer.setId(id);
		customer.setPassword(MD5Util.MD5EncodeUtf8(password));
		return customer;
	} 
	
	public static Customer assembleCustomer4Edit(String id, String fullName, String email, String phone, String address) {
		Customer customer = new Customer();
		customer.setId(id);
		customer.setFullName(fullName);
		customer.setEmail(email);
		customer.setPhone(phone);
		customer.setLocation(address);
		customer.setUpdateTime(new Date());
		return customer;
	} 
	
	public static Customer assembleCustomer4Register(String username, String password, String fullName, String email, Date birthday, String gender, String phone, String address, String referalId) {
		Customer customer = new Customer();
		customer.setUsername(username);
		customer.setPassword(MD5Util.MD5EncodeUtf8(password));
		customer.setFullName(fullName);
		customer.setEmail(email);
		customer.setBirthday(birthday);
		customer.setGender(gender);
		customer.setPhone(phone);
		customer.setLocation(address);
		if(StringUtils.isNotEmpty(referalId))
			customer.setCustomerReferal(referalId);
		Date createTime = new Date();
		customer.setCreateTime(createTime);
		customer.setUpdateTime(createTime);
		customer.setFlag(Flag.ENABLE);
		return customer;
	} 
	
	public static BigDecimal sumConfirmmedBookingItemPayment(List<BookingItem> items) {
		BigDecimal payment = new BigDecimal(0);
		for (BookingItem bookingItem : items) {
			if(BookingStatus.isEquale(bookingItem.getStatus(), BookingStatus.PENDING))
				return null;
			else if(BookingStatus.isEquale(bookingItem.getStatus(), BookingStatus.CONFIRM))
				payment = payment.add(bookingItem.getTotalPrice());
		}
		return payment;
	}
	
	public static BookingDetailVo assembleBookingDetailVO(Booking booking, List<BookingItem> items) {
		BookingDetailVo bookingDetail = new BookingDetailVo(); 
		bookingDetail.setBooking(booking);
		bookingDetail.setItems(items);
		return bookingDetail;
	}
	
	public static Booking assembleBookingForConfirm(Booking booking, Integer outdoorCharge, BigDecimal payment) {
		if(outdoorCharge != null) {
			BigDecimalUtil.add(payment.doubleValue(), outdoorCharge.doubleValue());
			booking.setOutdoorCharge(outdoorCharge);
			payment = payment.add(BigDecimal.valueOf(outdoorCharge));
		}
		booking.setPayment(payment);
		booking.setUpdateTime(new Date());
		booking.setBookingStatus(BookingStatus.CONFIRM.getCode());
		return booking;
	}
	
	public static Booking assembleBookingForDone(Booking booking) {
		Date date = new Date();
		booking.setUpdateTime(date);
		booking.setFinishTime(date);
		booking.setBookingStatus(BookingStatus.DONE.getCode());
		return booking;
	}
	
	public static boolean isAllBookingItemDone(List<BookingItem> items) {
		for (BookingItem bookingItem : items) {
			if(bookingItem.getStatus().intValue() != BookingStatus.DONE.getCode())
				return false;
		}
		return true;
	}
	
	public static BookingItem updateBookingItemForNewBooking(Integer id, Long bookingNo) {
		BookingItem item = new BookingItem();
		item.setId(id);
		item.setBookingNo(bookingNo);
		item.setUpdateTime(new Date());
		return item;
	}
	
	public static BookingItem assembleBookingItem(String customerId, Integer categoryId, Integer userCarId, Date createTime, String remark) {
		BookingItem item = new BookingItem();
		item.setUserId(customerId);
		item.setCategoryId(categoryId);
		if(userCarId != null)
			item.setUserCarId(userCarId);
		item.setCreateTime(createTime);
		item.setStatus(BookingStatus.PENDING.getCode());
		if(remark != null) 
			item.setRemark(remark);
		return item;
	}
	
	public static BookingItem assembleConfirmBookingItem(BookingItem bookingItem, Product product, Integer userCarId, BigDecimal otherCharge, String otherChargeInfo, Date bookingTime) {
		bookingItem.setProductId(product.getId());
		bookingItem.setBookingTime(bookingTime);
		bookingItem.setMerchant(product.getMarchant());
		bookingItem.setCurrentUnitPrice(product.getPrice());
		bookingItem.setUserCarId(userCarId);
		if(otherCharge != null) {
			bookingItem.setOtherCharge(otherCharge);
			bookingItem.setTotalPrice(product.getPrice().add(otherCharge));
		}	
		if(otherChargeInfo != null)
			bookingItem.setOtherChargeInfo(otherChargeInfo);
		bookingItem.setStatus(BookingStatus.CONFIRM.getCode());
		bookingItem.setUpdateTime(new Date());
		return bookingItem;
	}
	
	public static BookingItem assembleDoneBookingItem(BookingItem bookingItem) {
		Date date = new Date();
		bookingItem.setFinishTime(date);
		bookingItem.setUpdateTime(date);
		bookingItem.setStatus(BookingStatus.DONE.getCode());
		return bookingItem;
	}
	
	public static Booking createBooking(Long bookingNo, String customerId, Date bookingTime, Date createTime, String shipping) {
		Booking booking = new Booking();
		booking.setBookingNo(bookingNo);
		booking.setUserId(customerId);
		booking.setBookingTime(bookingTime);
		booking.setCreateTime(createTime);
		booking.setShipping(shipping);
		booking.setBookingStatus(BookingStatus.PENDING.getCode());
		return booking;
	}
	
	
	public static UserCar createUserCarSelective(String userId, String carInfo) {
		UserCar userCar = new UserCar();
		if(userId != null)
			userCar.setUserId(userId);
		if(carInfo != null)
			userCar.setCarInfo(carInfo);
		return userCar;
	}
	
	public static UserCar assembleUserCarForUpdate(Integer userCarId, String userId, String carInfo) {
		UserCar userCar = new UserCar();
		userCar.setId(userCarId);
		userCar.setUserId(userId);
		userCar.setCarInfo(carInfo);
		return userCar;
	}
	
	public static UserCar assembleUserCarForNew(String userId, String carInfo) {
		UserCar userCar = new UserCar();
		userCar.setUserId(userId);
		userCar.setCarInfo(carInfo);
		return userCar;
	}
	
	public static UserCarPicture assembleUserCarPicture(Integer userCarId, String nameOld, String nameNew, String path) {
		return new UserCarPicture(null, userCarId, nameOld, nameNew, path);
	}
	
	public static List<Integer> string2Integerlist(String s) {
		List<Integer> list = new ArrayList<Integer>();
		if(StringUtils.isEmpty(s))
			return list;
		String[] temp = s.split(",");
		for (String string : temp) 
			list.add(Integer.getInteger(string));
		return list;
	}
	
	public static long generateOrderNo(){
        long currentTime =System.currentTimeMillis();
        return currentTime+new Random().nextInt(100);
    }
}
