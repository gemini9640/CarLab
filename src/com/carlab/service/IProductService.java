package com.carlab.service;

import com.carlab.common.ServerResponse;
import com.carlab.db.Product;
import com.carlab.db.Staff;
import com.carlab.vo.ProductDetailVo;
import com.github.pagehelper.PageInfo;

public interface IProductService {
	public ServerResponse saveOrUpdateProduct(Staff staff, Product product);
	public ServerResponse<String> setSaleStatus(Staff staff, Integer productId, Integer status);
	public ServerResponse<ProductDetailVo> getProductDetailVoById(Integer productId);
	public ServerResponse<PageInfo> getList(Integer pageNum, Integer pageSize);
	public ServerResponse<PageInfo> searchProduct(String productName, String productId, Integer pageNum, Integer pageSize);
}
