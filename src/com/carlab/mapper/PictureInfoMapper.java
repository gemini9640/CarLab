package com.carlab.mapper;

import com.carlab.db.PictureInfo;

public interface PictureInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(PictureInfo record);

    int insertSelective(PictureInfo record);

    PictureInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PictureInfo record);

    int updateByPrimaryKey(PictureInfo record);
}