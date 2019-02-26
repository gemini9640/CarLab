package com.carlab.vo;

import java.util.List;

import com.carlab.db.BookingItem;

public class BookingCalenderDate {
	private Integer date;
	private List<BookingItem> bookingItems;

	public BookingCalenderDate() {
	}

	public BookingCalenderDate(Integer date,
			List<BookingItem> bookingItems) {
		this.date = date;
		this.bookingItems = bookingItems;
	}


	public Integer getDate() {
		return date;
	}

	public void setDate(Integer date) {
		this.date = date;
	}

	public List<BookingItem> getBookingItems() {
		return bookingItems;
	}

	public void setBookingItems(List<BookingItem> bookingItems) {
		this.bookingItems = bookingItems;
	}

	@Override
	public String toString() {
		return "BookingCalenderDate [date=" + date + ", bookingItems="
				+ bookingItems + "]";
	}


}
