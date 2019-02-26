package com.carlab.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.carlab.db.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);
    
    List<Product> searchProductByNameAndId(String productName, String productId);
    
    List<Product> selectProductByIds(@Param("ids") List<Integer> ids);
    
    List<Product> selectList();
}