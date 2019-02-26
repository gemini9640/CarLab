package com.carlab.db;

import java.math.BigDecimal;
import java.util.Date;

public class Booking {
    private Integer id;

    private Long bookingNo;

    private String userId;

    private String shipping;

    private BigDecimal payment;

    private Integer paymentType;

    private Integer outdoorCharge;

    private Integer bookingStatus;

    private Date paymentTime;

    private Date bookingTime;

    private Date shippingTime;

    private Date finishTime;

    private Date closeTime;

    private Date createTime;

    private Date updateTime;

    public Booking(Integer id, Long bookingNo, String userId, String shipping, BigDecimal payment, Integer paymentType, Integer outdoorCharge, Integer bookingStatus, Date paymentTime, Date bookingTime, Date shippingTime, Date finishTime, Date closeTime, Date createTime, Date updateTime) {
        this.id = id;
        this.bookingNo = bookingNo;
        this.userId = userId;
        this.shipping = shipping;
        this.payment = payment;
        this.paymentType = paymentType;
        this.outdoorCharge = outdoorCharge;
        this.bookingStatus = bookingStatus;
        this.paymentTime = paymentTime;
        this.bookingTime = bookingTime;
        this.shippingTime = shippingTime;
        this.finishTime = finishTime;
        this.closeTime = closeTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Booking() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(Long bookingNo) {
        this.bookingNo = bookingNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping == null ? null : shipping.trim();
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getOutdoorCharge() {
        return outdoorCharge;
    }

    public void setOutdoorCharge(Integer outdoorCharge) {
        this.outdoorCharge = outdoorCharge;
    }

    public Integer getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(Integer bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Date getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(Date bookingTime) {
        this.bookingTime = bookingTime;
    }

    public Date getShippingTime() {
        return shippingTime;
    }

    public void setShippingTime(Date shippingTime) {
        this.shippingTime = shippingTime;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", bookingNo=").append(bookingNo);
        sb.append(", userId=").append(userId);
        sb.append(", shipping=").append(shipping);
        sb.append(", payment=").append(payment);
        sb.append(", paymentType=").append(paymentType);
        sb.append(", outdoorCharge=").append(outdoorCharge);
        sb.append(", bookingStatus=").append(bookingStatus);
        sb.append(", paymentTime=").append(paymentTime);
        sb.append(", bookingTime=").append(bookingTime);
        sb.append(", shippingTime=").append(shippingTime);
        sb.append(", finishTime=").append(finishTime);
        sb.append(", closeTime=").append(closeTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}