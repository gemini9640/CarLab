package com.carlab.db;

import java.math.BigDecimal;
import java.util.Date;

public class Customer {
    private String id;

    private String username;

    private String password;

    private String fullName;

    private String gender;

    private Date birthday;

    private String phone;

    private String location;

    private String email;

    private String role;

    private Date createTime;

    private Date updateTime;

    private String code;

    private String customerReferal;

    private String selfReferal;

    private BigDecimal totalSpent;

    private String socialAccount;

    private String profilePicture;

    private Integer flag;

    private String remark;

    public Customer(String id, String username, String password, String fullName, String gender, Date birthday, String phone, String location, String email, String role, Date createTime, Date updateTime, String code, String customerReferal, String selfReferal, BigDecimal totalSpent, String socialAccount, String profilePicture, Integer flag, String remark) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.location = location;
        this.email = email;
        this.role = role;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.code = code;
        this.customerReferal = customerReferal;
        this.selfReferal = selfReferal;
        this.totalSpent = totalSpent;
        this.socialAccount = socialAccount;
        this.profilePicture = profilePicture;
        this.flag = flag;
        this.remark = remark;
    }

    public Customer() {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getCustomerReferal() {
        return customerReferal;
    }

    public void setCustomerReferal(String customerReferal) {
        this.customerReferal = customerReferal == null ? null : customerReferal.trim();
    }

    public String getSelfReferal() {
        return selfReferal;
    }

    public void setSelfReferal(String selfReferal) {
        this.selfReferal = selfReferal == null ? null : selfReferal.trim();
    }

    public BigDecimal getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(BigDecimal totalSpent) {
        this.totalSpent = totalSpent == null? new BigDecimal(0.00) : totalSpent;
    }

    public String getSocialAccount() {
        return socialAccount;
    }

    public void setSocialAccount(String socialAccount) {
        this.socialAccount = socialAccount == null ? null : socialAccount.trim();
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture == null ? null : profilePicture.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
        sb.append(", birthday=").append(birthday);
        sb.append(", phone=").append(phone);
        sb.append(", location=").append(location);
        sb.append(", email=").append(email);
        sb.append(", role=").append(role);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", code=").append(code);
        sb.append(", customerReferal=").append(customerReferal);
        sb.append(", selfReferal=").append(selfReferal);
        sb.append(", totalSpent=").append(totalSpent);
        sb.append(", socialAccount=").append(socialAccount);
        sb.append(", profilePicture=").append(profilePicture);
        sb.append(", flag=").append(flag);
        sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}