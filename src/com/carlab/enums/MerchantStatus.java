package com.carlab.enums;

public enum MerchantStatus {
	PENDING(0,"pending"),
	APPROVED(1,"approved"),
	TERMINATE(2,"terminate");
	
	
	public static MerchantStatus getByCode(Integer code) {
		for (MerchantStatus status : values()) {
			if(status.getCode() == code)
				return status;
		}
		return null;
	}
	
	public static boolean isEquale(Integer status, MerchantStatus bookingStatus) {
		return status == null ? false : status.intValue() == bookingStatus.getCode();
	}
	
	private MerchantStatus(int code, String text) {
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
