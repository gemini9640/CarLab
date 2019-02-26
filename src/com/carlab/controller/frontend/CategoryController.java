package com.carlab.controller.frontend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carlab.common.ServerResponse;
import com.carlab.service.IProductService;
import com.carlab.vo.multiLevelMenu.MutilLevelMenu;

@Controller
@RequestMapping("/category")
public class CategoryController {
//	@Autowired
//    private IUserService iUserService;
    @Autowired
    private IProductService iProductService;

    @RequestMapping(value = "menu/product.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<List<MutilLevelMenu>> productCateMenu() {
    		return null;
    }
}
