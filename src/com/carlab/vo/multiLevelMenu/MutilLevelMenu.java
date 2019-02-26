package com.carlab.vo.multiLevelMenu;

import java.util.List;

public class MutilLevelMenu {
	private String menuId;
	private String menuName;
	private List<MutilLevelMenu> subMenus;

	public MutilLevelMenu() {
	}

	public MutilLevelMenu(String menuId, String menuName, List<MutilLevelMenu> subMenus) {
		this.menuId = menuId;
		this.menuName = menuName;
		this.subMenus = subMenus;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public List<MutilLevelMenu> getSubMenus() {
		return subMenus;
	}

	public void setSubMenus(List<MutilLevelMenu> subMenus) {
		this.subMenus = subMenus;
	}

	@Override
	public String toString() {
		return "MutilLevelMenu [menuId=" + menuId + ", menuName=" + menuName
				+  ", subMenus=" + subMenus + "]";
	}

	
}
