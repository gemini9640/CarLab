package com.carlab.service;

import java.util.List;

import com.carlab.common.ServerResponse;
import com.carlab.db.ProductCategory;
import com.carlab.db.Staff;
import com.carlab.vo.multiLevelMenu.MutilLevelMenu;

public interface IProductCategoryService {
	 public ServerResponse addCategory(Staff staff, String categoryName, Integer parentId);
	 public ServerResponse updateCategoryName(Staff staff, Integer categoryId, String categoryName);
	 public ServerResponse<List<ProductCategory>> getChildrenParallelCategory(Integer categoryId);
	 public ServerResponse selectCategoryAndChildrenById(Integer categoryId);
	 public MutilLevelMenu findChildCategoryMenu(Integer categoryId);
}
