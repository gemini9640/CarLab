package com.carlab.service;

import java.util.List;

import com.carlab.common.ServerResponse;
import com.carlab.db.UserCar;
import com.carlab.db.UserCarPicture;
import com.carlab.vo.UserCarVo;

public interface IUserCarService {
	public ServerResponse<UserCar> saveUserCarAndPicture(String userId, List<UserCarPicture> pictures);
	
	public ServerResponse<List<UserCarPicture>> saveUserCarPicture(Integer userCarId, List<UserCarPicture> pictures);
	
	public ServerResponse<UserCar> updateUserCar(String userId, Integer carId, String carInfo);
	
	public ServerResponse<UserCarVo> queryUserCarInfo(Integer carId);
}
