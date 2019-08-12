package com.carlab.enums;

public enum BookingStatus {
	PENDING(0,"Pending"),
	CONFIRM(1,"Confirmmed"),
	ONGOING(2,"On going"),
	DONE(3,"Done"),
	CANCEL(-1,"Cancel");
	
	
	public static BookingStatus getByCode(Integer code) {
		for (BookingStatus status : values()) {
			if(status.getCode() == code)
				return status;
		}
		return null;
	}
	
	public static String getTextByCode(Integer code) {
		for (BookingStatus status : values()) {
			if(status.getCode() == code)
				return status.getText();
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
