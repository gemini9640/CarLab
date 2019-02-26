package com.carlab.mapper;

import java.util.List;
import com.carlab.db.ProductCategory;

public interface ProductCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProductCategory record);

    int insertSelective(ProductCategory record);

    ProductCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProductCategory record);

    int updateByPrimaryKey(ProductCategory record);
    
    List<ProductCategory> selectCategoryChildrenByParentId(Integer categoryId);
    
}