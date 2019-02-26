package com.carlab.vo;

import java.util.Map;

public class BookingCalenderMonth {
	private Integer month;
	private Map<Integer, BookingCalenderDate> bookingCalenderDateMap;

	public BookingCalenderMonth() {
	}

	public BookingCalenderMonth(Integer month,
			Map<Integer, BookingCalenderDate> bookingCalenderDateMap) {
		this.month = month;
		this.bookingCalenderDateMap = bookingCalenderDateMap;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Map<Integer, BookingCalenderDate> getBookingCalenderDateMap() {
		return bookingCalenderDateMap;
	}

	public void setBookingCalenderDateMap(
			Map<Integer, BookingCalenderDate> bookingCalenderDateMap) {
		this.bookingCalenderDateMap = bookingCalenderDateMap;
	}
	
}
