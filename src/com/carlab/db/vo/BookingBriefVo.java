package com.carlab.db.vo;

public class BookingBriefVo {
	private Long bookingNo;
	private String category;
	private String username;
	private String email;
	private String phoneNo;
	private String createTime;
	private String status;
	private String merchant;

	public BookingBriefVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookingBriefVo(Long bookingNo, String category, String username, String email, String phoneNo,
			String createTime, String status, String merchant) {
		super();
		this.bookingNo = bookingNo;
		this.category = category;
		this.username = username;
		this.email = email;
		this.phoneNo = phoneNo;
		this.createTime = createTime;
		this.status = status;
		this.merchant = merchant;
	}

	public Long getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(Long bookingNo) {
		this.bookingNo = bookingNo;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMerchant() {
		return merchant;
	}

	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}

	@Override
	public String toString() {
		return "BookingBrief [bookingNo=" + bookingNo + ", category=" + category + ", username=" + username + ", email="
				+ email + ", phoneNo=" + phoneNo + ", createTime=" + createTime + ", status=" + status + ", merchant="
				+ merchant + "]";
	}

}
