package com.carlab.enums;

public enum BookingStatus {
	SUBMIT(0,"submit"),
	CONFIRM(1,"confirm"),
	ONGOING(2,"on going"),
	DONE(3,"done"),
	CANCEL(-1,"cancel");
	
	
	public static BookingStatus getByCode(Integer code) {
		for (BookingStatus status : values()) {
			if(status.getCode() == code)
				return status;
		}
		return null;
	}
	
	public static boolean isEquale(Integer status, BookingStatus bookingStatus) {
		return status == null ? false : status.intValue() == bookingStatus.getCode();
	}
	
	private BookingStatus(int code, String text) {
		this.code = code;
		this.text = text;
	}
	
	private int code;
	private String text;
	public int getCode() {
		return code;
	}
	public String getText() {
		return text;
	}
}
