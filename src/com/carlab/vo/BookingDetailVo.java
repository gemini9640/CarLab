package com.carlab.vo;

import java.util.List;

import com.carlab.db.Booking;
import com.carlab.db.BookingItem;

public class BookingDetailVo {
	private Booking booking;
	private List<BookingItem> items;
	
	public BookingDetailVo() {
	}
	
	public BookingDetailVo(Booking booking, List<BookingItem> items) {
		this.booking = booking;
		this.items = items;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public List<BookingItem> getItems() {
		return items;
	}

	public void setItems(List<BookingItem> items) {
		this.items = items;
	}
	
}
