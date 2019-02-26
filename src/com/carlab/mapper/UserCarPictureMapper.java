package com.carlab.mapper;

import java.util.List;

import com.carlab.db.UserCarPicture;

public interface UserCarPictureMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(UserCarPicture record);

	int insertSelective(UserCarPicture record);

	UserCarPicture selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(UserCarPicture record);

	int updateByPrimaryKey(UserCarPicture record);
    
    List<UserCarPicture> selectByUserCarId(Integer userCarId);
    
    Integer countByUserCarId(Integer userCarId);
    
    int batchInsertForNew(List<UserCarPicture> items);
}