package com.carlab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlab.common.ServerResponse;
import com.carlab.db.UserCar;
import com.carlab.db.UserCarPicture;
import com.carlab.enums.ResponseCode;
import com.carlab.mapper.UserCarMapper;
import com.carlab.mapper.UserCarPictureMapper;
import com.carlab.service.IUserCarService;
import com.carlab.utils.CarlabHelper;
import com.carlab.vo.UserCarVo;

@Service("iUserCarService")
public class UserCarServiceImpl implements IUserCarService {
	@Autowired
	private UserCarMapper userCarMapper;
	@Autowired 
	private UserCarPictureMapper userCarPictureMapper;
	
	public ServerResponse<UserCar> saveUserCarAndPicture(String userId, List<UserCarPicture> pictures) {
		UserCar userCar = CarlabHelper.createUserCarSelective(userId, null);
		userCarMapper.insertSelective(userCar);//mybatis已处理主键赋值
		for (UserCarPicture userCarPicture : pictures)
			userCarPicture.setUserCarId(userCar.getId());
		userCarPictureMapper.batchInsertForNew(pictures);
		return ServerResponse.createBySuccess(userCar);
	}
	
	public ServerResponse<List<UserCarPicture>> saveUserCarPicture(Integer userCarId, List<UserCarPicture> pictures) {
		for (UserCarPicture userCarPicture : pictures)
			userCarPicture.setUserCarId(userCarId);
		userCarPictureMapper.batchInsertForNew(pictures);
		return ServerResponse.createBySuccess(pictures);
	}
	
	public ServerResponse<UserCar> updateUserCar(String userId, Integer carId, String carInfo) {
		UserCar userCar = CarlabHelper.assembleUserCarForUpdate(carId, userId, carInfo);
		if(userCarMapper.updateByPrimaryKeySelective(userCar)>0)
			return ServerResponse.createBySuccess(userCar);
		else 
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ILLIGAL_ARGUMENT.getCode(), ResponseCode.ILLIGAL_ARGUMENT.getDesc());
	}
	
	public ServerResponse<UserCarVo> queryUserCarInfo(Integer carId) {
		UserCar userCar = userCarMapper.selectByPrimaryKey(carId);
		List<UserCarPicture> pictures = userCarPictureMapper.selectByUserCarId(carId);
		UserCarVo vo = CarlabHelper.assembleUserCarVo(userCar, pictures);
		return ServerResponse.createBySuccess(vo);
	}
}
