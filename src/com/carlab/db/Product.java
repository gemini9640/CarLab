package com.carlab.db;

import java.math.BigDecimal;
import java.util.Date;

public class Product {
    private Integer id;

    private Integer categoryId;

    private String marchant;

    private String name;

    private String subtitle;
    
    private Integer duration;

    private BigDecimal price;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private String detail;

    public Product(Integer id, Integer categoryId, String marchant, String name, String subtitle, BigDecimal price, Integer status, Date createTime, Date updateTime, String detail) {
        this.id = id;
        this.categoryId = categoryId;
        this.marchant = marchant;
        this.name = name;
        this.subtitle = subtitle;
        this.price = price;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.detail = detail;
    }

    public Product() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getMarchant() {
        return marchant;
    }

    public void setMarchant(String marchant) {
        this.marchant = marchant == null ? null : marchant.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle == null ? null : subtitle.trim();
    }

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", categoryId=").append(categoryId);
        sb.append(", marchant=").append(marchant);
        sb.append(", name=").append(name);
        sb.append(", subtitle=").append(subtitle);
        sb.append(", duration=").append(duration);
        sb.append(", price=").append(price);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", detail=").append(detail);
        sb.append("]");
        return sb.toString();
    }
}