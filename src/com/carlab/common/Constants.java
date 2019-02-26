package com.carlab.common;

public class Constants {
	public static final String CURRENT_USER = "currentUser";
    public static final String EMAIL = "email";
    public static final String CUSTOMER_SESSION = "CUSTOMER_SESSION";
    public static final String STAFF_SESSION = "STAFF_SESSION";
    public static final String STAFF_ID_PREFIX = "EM_";
    public static final String CUSTOMER_ID_PREFIX = "CC_";
    public static final String MERCHANT_ID_PREFIX = "CM_";
    
    public interface Flag {
        int ENABLE = 0; // 普通用户
        int DISABLE = 1; // 管理员
    }
}
