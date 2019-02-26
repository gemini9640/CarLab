package com.carlab.vo;

import java.util.List;

public class UserCarVo {
	private String carId;
	private String carInfo;
	private List<String> picturePaths;

	public UserCarVo() {
	}

	public UserCarVo(String carId, String carInfo, List<String> picturePaths) {
		this.carId = carId;
		this.carInfo = carInfo;
		this.picturePaths = picturePaths;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public String getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(String carInfo) {
		this.carInfo = carInfo;
	}

	public List<String> getPicturePaths() {
		return picturePaths;
	}

	public void setPicturePaths(List<String> picturePaths) {
		this.picturePaths = picturePaths;
	}

	public String toString() {
		return "UserCarVo [carId=" + carId + ", carInfo=" + carInfo
				+ ", picturePaths=" + picturePaths + "]";
	}

}
