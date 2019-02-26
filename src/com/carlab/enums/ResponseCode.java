package com.carlab.enums;

public enum ResponseCode {
	SUCCESS(0,"SUCCESS"),
    ERROR(1,"server error, try again later"),
    ILLIGAL_ARGUMENT(2,"ILLIGAL_ARGUMENT"),
    NEED_LOGIN(10,"NEED_LOGIN");

    private int code;
    private String desc;

    private ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
