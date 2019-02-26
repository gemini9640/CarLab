package com.carlab.utils;

import com.carlab.db.Product;
import com.carlab.db.ProductCategory;
import com.carlab.vo.ProductDetailVo;
import com.carlab.vo.ProductListVo;

public class CarlabVOUtil {
	
	public static ProductListVo assembleProductListVo(Product product) {
        ProductListVo productListVo = new ProductListVo();
        productListVo.setId(product.getId());
        productListVo.setCategoryId(product.getCategoryId());
        productListVo.setName(product.getName());
        productListVo.setSubTitle(product.getSubtitle());
        productListVo.setPrice(product.getPrice());
        productListVo.setStatus(product.getStatus());
        return productListVo;
    }
	
	public static ProductDetailVo assembleProductDetailVo(Product product, ProductCategory category) {
        ProductDetailVo productDetailVo = new ProductDetailVo();
        productDetailVo.setId(product.getId());
        productDetailVo.setSubTitle(product.getSubtitle());
        productDetailVo.setName(product.getName());
        productDetailVo.setCategoryId(product.getCategoryId());
        productDetailVo.setDetail(product.getDetail());
        productDetailVo.setPrice(product.getPrice());

        if(category == null) 
            productDetailVo.setParentCategoryId(0);
        else 
            productDetailVo.setParentCategoryId(category.getParentId());

        productDetailVo.setCreateTime(DateTimeUtil.dateToStr(product.getCreateTime()));
        productDetailVo.setUpdateTime(DateTimeUtil.dateToStr(product.getUpdateTime()));
        return productDetailVo;
    }
}
