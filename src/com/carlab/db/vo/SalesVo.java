package com.carlab.db.vo;

public class SalesVo {
	private String category;
	private String sales;
	private String date;
	
	public SalesVo() {
	}
	
	public SalesVo(String category, String sales, String date) {
		this.category = category;
		this.sales = sales;
		this.date = date;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSales() {
		return sales;
	}
	public void setSales(String sales) {
		this.sales = sales;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "sales [category=" + category + ", sales=" + sales + ", date=" + date + "]";
	}
	
	
}
