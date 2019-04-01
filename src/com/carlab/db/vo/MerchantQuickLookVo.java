package com.carlab.db.vo;

import java.util.Date;

public class MerchantQuickLookVo {
	private String id;
	private String company;
	private Date createTime;
	private String createTimeShortForm;
	private String logo;
	private Integer status;

	public MerchantQuickLookVo() {
	}


	public MerchantQuickLookVo(String id, String company, Date createTime, String createTimeShortForm, String logo,
			Integer status) {
		this.id = id;
		this.company = company;
		this.createTime = createTime;
		this.createTimeShortForm = createTimeShortForm;
		this.logo = logo;
		this.status = status;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
		setCreateTimeShortForm(createTime.toString());
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreateTimeShortForm() {
		return createTimeShortForm;
	}

	public void setCreateTimeShortForm(String createTimeShortForm) {
		this.createTimeShortForm = createTimeShortForm;
	}


	@Override
	public String toString() {
		return "MerchantQuickLookVo [id=" + id + ", company=" + company + ", createTime=" + createTime
				+ ", createTimeShortForm=" + createTimeShortForm + ", logo=" + logo + ", status=" + status + "]";
	}
	
}
