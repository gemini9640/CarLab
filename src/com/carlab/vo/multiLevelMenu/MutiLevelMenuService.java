package com.carlab.vo.multiLevelMenu;

import java.util.List;

public interface MutiLevelMenuService {
	public List<MutilLevelMenu> selectSubMenusByParentId(String s);
}
