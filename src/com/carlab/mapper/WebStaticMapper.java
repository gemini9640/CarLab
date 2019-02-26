package com.carlab.mapper;

import com.carlab.db.WebStatic;

public interface WebStaticMapper {
    int deleteByPrimaryKey(String id);

    int insert(WebStatic record);

    int insertSelective(WebStatic record);

    WebStatic selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WebStatic record);

    int updateByPrimaryKey(WebStatic record);
}