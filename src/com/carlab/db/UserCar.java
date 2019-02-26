package com.carlab.db;

public class UserCar {
    private Integer id;

    private String userId;

    private String carInfo;

    public UserCar(Integer id, String userId, String carInfo) {
        this.id = id;
        this.userId = userId;
        this.carInfo = carInfo;
    }

    public UserCar() {
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

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo == null ? null : carInfo.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", carInfo=").append(carInfo);
        sb.append("]");
        return sb.toString();
    }
}