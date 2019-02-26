package com.carlab.db;

import java.util.Date;

public class Merchant {
    private String id;

    private String username;

    private String password;

    private String fullName;
    
    private String gender;
    
    private String ic;

    private String company;

    private String phone;

    private String email;

    private String role;

    private String regNo;

    private String referer;

    private Double commissionRate;

    private String logo;

    private Date createTime;

    private Date updateTime;

    private Integer flag;

    public Merchant(String id, String username, String password, String fullName, String gender, String ic, String company, String phone, String email, String role, String regNo, String referer, Double commissionRate, String logo, Date createTime, Date updateTime, Integer flag) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.gender = gender;
        this.ic = ic;
        this.company = company;
        this.phone = phone;
        this.email = email;
        this.role = role;
        this.regNo = regNo;
        this.referer = referer;
        this.commissionRate = commissionRate;
        this.logo = logo;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.flag = flag;
    }

    public Merchant() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo == null ? null : regNo.trim();
    }

    public String getReferer() {
        return referer;
    }

    public void setReferer(String referer) {
        this.referer = referer == null ? null : referer.trim();
    }

    public Double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
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

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIc() {
		return ic;
	}

	public void setIc(String ic) {
		this.ic = ic;
	}

	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", fullName=").append(fullName);
        sb.append(", gender=").append(gender);
        sb.append(", id=").append(ic);
        sb.append(", company=").append(company);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", role=").append(role);
        sb.append(", regNo=").append(regNo);
        sb.append(", referer=").append(referer);
        sb.append(", commissionRate=").append(commissionRate);
        sb.append(", logo=").append(logo);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", flag=").append(flag);
        sb.append("]");
        return sb.toString();
    }
}