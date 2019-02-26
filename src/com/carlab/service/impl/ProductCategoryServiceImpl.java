package com.carlab.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlab.common.ServerResponse;
import com.carlab.db.ProductCategory;
import com.carlab.db.Staff;
import com.carlab.mapper.ProductCategoryMapper;
import com.carlab.service.IProductCategoryService;
import com.carlab.vo.multiLevelMenu.MutiLevelMenuService;
import com.carlab.vo.multiLevelMenu.MutiLevelMenuUtil;
import com.carlab.vo.multiLevelMenu.MutilLevelMenu;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

@Service("iProductCategoryService")
public class ProductCategoryServiceImpl implements IProductCategoryService,  MutiLevelMenuService{
	private Logger logger = LoggerFactory.getLogger(ProductCategoryServiceImpl.class);
	@Autowired
	private ProductCategoryMapper productCategoryMapper;

	public ServerResponse addCategory(Staff staff, String categoryName, Integer parentId) {
		if (parentId == null || StringUtils.isBlank(categoryName)) 
			return ServerResponse.createByErrorMsg("添加产品分类错误");
		

		ProductCategory category = new ProductCategory();
		category.setName(categoryName);
		category.setParentId(parentId);
		category.setStatus(true);// 这个分类是可用的

		int rowCount = productCategoryMapper.insert(category);
		if (rowCount > 0) 
			return ServerResponse.createBySuccessMsg("添加品类成功");
		return ServerResponse.createByErrorMsg("添加品类失败");
	}

	public ServerResponse updateCategoryName(Staff staff, Integer categoryId, String categoryName) {
		if (categoryId == null || StringUtils.isBlank(categoryName)) 
			return ServerResponse.createByErrorMsg("更新产品分类错误");

		ProductCategory category = new ProductCategory();
		category.setId(categoryId);
		category.setName(categoryName);

		int rowCount = productCategoryMapper.updateByPrimaryKeySelective(category);
		if (rowCount > 0) 
			return ServerResponse.createBySuccessMsg("更新品类名字成功");
		return ServerResponse.createByErrorMsg(" 更新品类名字失败");
	}

	/**
	 * 递归查询本节点ID 及子节点ID
	 * 
	 * @param categoryId
	 * @return
	 */
	public ServerResponse<List<ProductCategory>> getChildrenParallelCategory(Integer categoryId) {
		List<ProductCategory> categoryList = productCategoryMapper.selectCategoryChildrenByParentId(categoryId);
		if (CollectionUtils.isEmpty(categoryList)) 
			logger.info("未找到到这个类的子分类");
		return ServerResponse.createBySuccess(categoryList);
	}

	public ServerResponse selectCategoryAndChildrenById(Integer categoryId) {
		Set<ProductCategory> categorySet = Sets.newHashSet();
		findChildCategory(categorySet, categoryId);

		List<Integer> categoryIdList = Lists.newArrayList();
		if (categoryId != null) {
			for (ProductCategory categoryItem : categorySet) 
				categoryIdList.add(categoryItem.getId());
		}
		return ServerResponse.createBySuccess(categoryIdList);
	}

	// 递归算法,算出子节点
	private Set<ProductCategory> findChildCategory(Set<ProductCategory> categorySet, Integer categoryId) {
		ProductCategory category = productCategoryMapper.selectByPrimaryKey(categoryId);
		if (category != null) 
			categorySet.add(category);
		// 查找子节点
		List<ProductCategory> categoryList = productCategoryMapper.selectCategoryChildrenByParentId(categoryId);
		for (ProductCategory categoryItem : categoryList) 
			findChildCategory(categorySet, categoryItem.getId());
		return categorySet;
	}
	
	public MutilLevelMenu findChildCategoryMenu(Integer categoryId) {
		ProductCategory productCategory = productCategoryMapper.selectByPrimaryKey(categoryId);
		MutilLevelMenu menu = MutiLevelMenuUtil.assembledMutilLevelMenu(productCategory.getId()+"", productCategory.getName());
		return MutiLevelMenuUtil.findChildCategoryMenu(menu, this);
	}
	
	/**
	 * MutiLevelMenuService.selectCategoryChildrenByParentId
	 */
	public List<MutilLevelMenu> selectSubMenusByParentId(String categoryId) {
		List<MutilLevelMenu> menus = new ArrayList<MutilLevelMenu>();
		List<ProductCategory> productCategories = productCategoryMapper.selectCategoryChildrenByParentId(new Integer(categoryId));
		for (ProductCategory productCategory : productCategories)
			menus.add(MutiLevelMenuUtil.assembledMutilLevelMenu(productCategory.getId()+"", productCategory.getName()));
		return menus;
	}
}
