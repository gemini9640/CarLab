package com.carlab.mapper;

import com.carlab.db.SysProperty;

public interface SysPropertyMapper {
    int deleteByPrimaryKey(String key);

    int insert(SysProperty record);

    int insertSelective(SysProperty record);

    SysProperty selectByPrimaryKey(String key);

    int updateByPrimaryKeySelective(SysProperty record);

    int updateByPrimaryKey(SysProperty record);
}