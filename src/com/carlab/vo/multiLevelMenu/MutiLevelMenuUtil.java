package com.carlab.vo.multiLevelMenu;

import java.util.List;

public class MutiLevelMenuUtil {
	
	public static MutilLevelMenu findChildCategoryMenu(MutilLevelMenu parentMenu, MutiLevelMenuService menuService) {
		if (parentMenu == null) 
			return null;
		// 查找子节点
		List<MutilLevelMenu> subMenus = menuService.selectSubMenusByParentId(parentMenu.getMenuId());
		for (MutilLevelMenu subMenu : subMenus)
			findChildCategoryMenu(subMenu, menuService); 
		parentMenu.setSubMenus(subMenus);
		return parentMenu;
	}
	
	public static MutilLevelMenu assembledMutilLevelMenu(String id, String name) {
		MutilLevelMenu menu = new MutilLevelMenu();
		menu.setMenuId(id);
		menu.setMenuName(name);
		return menu;
	}
}
