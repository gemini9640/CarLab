package com.carlab.vo;

import java.math.BigDecimal;

public class ProductDetailVo {
	private Integer id;
    private Integer categoryId;
    private String name;
    private String subTitle;
    private String detail;
    private BigDecimal price;
    private Integer status;
    private String createTime;
    private String updateTime;
    private Integer parentCategoryId;

    public ProductDetailVo() {
    }

    public ProductDetailVo(Integer id, Integer categoryId, String name, String subtitle, String detail, BigDecimal price, Integer status, String createTime, String updateTime, Integer parentCategoryId) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.subTitle = subtitle;
        this.detail = detail;
        this.price = price;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.parentCategoryId = parentCategoryId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }


    public Integer getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(Integer parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

}
