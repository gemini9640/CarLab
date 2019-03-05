package com.carlab.db;

import java.math.BigDecimal;
import java.util.Date;

import com.carlab.utils.DateUtil;

public class BookingItem {
    private Integer id;

    private String userId;

    private Long bookingNo;

    private Integer productId;

    private Integer categoryId;

    private Integer userCarId;

    private String merchant;

    private BigDecimal currentUnitPrice;

    private BigDecimal otherCharge;

    private String otherChargeInfo;

    private BigDecimal totalPrice;

    private Date createTime;

    private Integer status;

    private Date updateTime;

    private Date bookingTime;

    private Date finishTime;

    private String remark;

    public BookingItem(Integer id, String userId, Long bookingNo, Integer productId, Integer categoryId, Integer userCarId, String merchant, BigDecimal currentUnitPrice, BigDecimal otherCharge, String otherChargeInfo, BigDecimal totalPrice, Date createTime, Integer status, Date updateTime, Date bookingTime, Date finishTime, String remark) {
        this.id = id;
        this.userId = userId;
        this.bookingNo = bookingNo;
        this.productId = productId;
        this.categoryId = categoryId;
        this.userCarId = userCarId;
        this.merchant = merchant;
        this.currentUnitPrice = currentUnitPrice;
        this.otherCharge = otherCharge;
        this.otherChargeInfo = otherChargeInfo;
        this.totalPrice = totalPrice;
        this.createTime = createTime;
        this.status = status;
        this.updateTime = updateTime;
        this.bookingTime = bookingTime;
        this.finishTime = finishTime;
        this.remark = remark;
    }

    public BookingItem() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Long getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(Long bookingNo) {
        this.bookingNo = bookingNo;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getUserCarId() {
        return userCarId;
    }

    public void setUserCarId(Integer userCarId) {
        this.userCarId = userCarId;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant == null ? null : merchant.trim();
    }

    public BigDecimal getCurrentUnitPrice() {
        return currentUnitPrice;
    }

    public void setCurrentUnitPrice(BigDecimal currentUnitPrice) {
        this.currentUnitPrice = currentUnitPrice;
    }

    public BigDecimal getOtherCharge() {
        return otherCharge;
    }

    public void setOtherCharge(BigDecimal otherCharge) {
        this.otherCharge = otherCharge;
    }

    public String getOtherChargeInfo() {
        return otherChargeInfo;
    }

    public void setOtherChargeInfo(String otherChargeInfo) {
        this.otherChargeInfo = otherChargeInfo == null ? null : otherChargeInfo.trim();
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	@Override
	public String toString() {
		return "BookingItem [id=" + id + ", userId=" + userId + ", bookingNo="
				+ bookingNo + ", productId=" + productId + ", categoryId="
				+ categoryId + ", userCarId=" + userCarId + ", merchant="
				+ merchant + ", currentUnitPrice=" + currentUnitPrice
				+ ", otherCharge=" + otherCharge + ", otherChargeInfo="
				+ otherChargeInfo + ", totalPrice=" + totalPrice
				+ ", createTime=" + createTime + ", status="
				+ status + ", updateTime=" + updateTime
				+ ", bookingTime=" + bookingTime + ", finishTime=" + finishTime
				+ ", remark=" + remark + "]";
	}

}