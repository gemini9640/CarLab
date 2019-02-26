package com.carlab.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.carlab.db.Customer;

public interface CustomerMapper {
    int deleteByPrimaryKey(String id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
    
    //new
    List<Customer> selectAll();
    
    Customer selectByKeyAndPass(@Param("id")String id, @Param("password")String password);
    
    Customer login(@Param("username")String username, @Param("password")String password);
}