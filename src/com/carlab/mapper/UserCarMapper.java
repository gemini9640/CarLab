package com.carlab.mapper;

import com.carlab.db.UserCar;

public interface UserCarMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserCar record);

    int insertSelective(UserCar record);

    UserCar selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserCar record);

    int updateByPrimaryKey(UserCar record);
    
    int updateCarInfoByKeyAndUserId(UserCar record);
}