package com.carlab.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlab.common.ServerResponse;
import com.carlab.db.Product;
import com.carlab.db.Staff;
import com.carlab.enums.ResponseCode;
import com.carlab.mapper.ProductCategoryMapper;
import com.carlab.mapper.ProductMapper;
import com.carlab.service.IProductService;
import com.carlab.utils.CarlabVOUtil;
import com.carlab.vo.ProductDetailVo;
import com.carlab.vo.ProductListVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("iProductService")
public class ProductServiceImpl implements IProductService{
	@Autowired
    private ProductCategoryMapper categoryMapper;
	@Autowired
	private ProductMapper productMapper;
	
    public ServerResponse saveOrUpdateProduct(Staff staff, Product product) {
        if (product != null) {
            if (product.getId() != null) {
                int rowCount = productMapper.insert(product);
                if (rowCount > 0) 
                    return ServerResponse.createBySuccessMsg("产品添加成功");
                return ServerResponse.createByErrorMsg("产品添加失败");
            } else {
                int rowCount = productMapper.updateByPrimaryKey(product);
                if (rowCount > 0) 
                    return ServerResponse.createBySuccessMsg("产品更新成功");
                return ServerResponse.createByErrorMsg("产品更新失败");
            }
        }
        return ServerResponse.createByErrorMsg("参数错误,更新或添加失败");
    }

    public ServerResponse<String> setSaleStatus(Staff staff, Integer productId, Integer status) {
        if(productId == null || status == null) 
            return ServerResponse.createByErrorCodeMsg(ResponseCode.ILLIGAL_ARGUMENT.getCode(),ResponseCode.ILLIGAL_ARGUMENT.getDesc());

        Product product = new Product();
        product.setId(productId);
        product.setStatus(status);
        int rowCount = productMapper.updateByPrimaryKeySelective(product);
        if (rowCount > 0) 
            return ServerResponse.createBySuccessMsg("产品更新成功");
        return ServerResponse.createByErrorMsg("产品更新失败");
    }

    public ServerResponse<ProductDetailVo> getProductDetailVoById(Integer productId) {
        if(productId == null) 
            return ServerResponse.createByErrorCodeMsg(ResponseCode.ILLIGAL_ARGUMENT.getCode(),ResponseCode.ILLIGAL_ARGUMENT.getDesc());
        
        Product product = productMapper.selectByPrimaryKey(productId);
        if(product == null) 
            return ServerResponse.createByErrorMsg("service is not avaliable");
         return ServerResponse.createBySuccess(CarlabVOUtil.assembleProductDetailVo(product, categoryMapper.selectByPrimaryKey(product.getCategoryId())));
    }

    

    public ServerResponse<PageInfo> getList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Product> productlist = productMapper.selectList();
        List<ProductListVo> productListVoList = new ArrayList<ProductListVo>();
        for(Product product: productlist) {
        	productListVoList.add(CarlabVOUtil.assembleProductListVo(product));
        }

        //pagehelper动态分页
        //httpoding.imooc.com/learn/questiondetail/qid/19765
        PageInfo pageResult = new PageInfo(productlist);
        pageResult.setList(productListVoList);
        return ServerResponse.createBySuccess(pageResult);
    }

    public ServerResponse<PageInfo> searchProduct(String productName, String productId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        if(StringUtils.isNotBlank(productName)) {
        	productName = new StringBuilder().append("%").append(productName).append("%").toString();
        }
        List<Product> productlist = productMapper.searchProductByNameAndId(productName, productId);
        List<ProductListVo> productListVoList = new ArrayList<ProductListVo>();
        for(Product product: productlist) {
        		productListVoList.add(CarlabVOUtil.assembleProductListVo(product));
        }

        //pagehelper动态分页
        //httpoding.imooc.com/learn/questiondetail/qid/19765
        PageInfo pageResult = new PageInfo(productlist);
        pageResult.setList(productListVoList);
        return ServerResponse.createBySuccess(pageResult);
    }

    

}
