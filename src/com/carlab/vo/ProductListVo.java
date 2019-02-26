package com.carlab.vo;

import java.math.BigDecimal;

public class ProductListVo {
	private Integer id;
    private Integer categoryId;
    private String name;
    private String subTitle;
    private BigDecimal price;
    private Integer status;

    public ProductListVo() {
    }

    public ProductListVo(Integer id, Integer categoryId, String name, String subTitle, BigDecimal price, Integer status) {
        this.id = id;
        this.categoryId = categoryId;
        this.name = name;
        this.subTitle = subTitle;
        this.price = price;
        this.status = status;
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

}
