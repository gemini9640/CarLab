package com.carlab.mapper;

import com.carlab.db.Booking;

public interface BookingMapper {
	int deleteByPrimaryKey(Integer id);

    int insert(Booking record);

    int insertSelective(Booking record);

    Booking selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Booking record);

    int updateByPrimaryKey(Booking record);
}