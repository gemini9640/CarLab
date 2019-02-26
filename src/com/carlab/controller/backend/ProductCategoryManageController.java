package com.carlab.controller.backend;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carlab.common.Constants;
import com.carlab.common.ServerResponse;
import com.carlab.controller.base.BaseController;
import com.carlab.enums.ResponseCode;
import com.carlab.service.IProductCategoryService;

@Controller
@RequestMapping("/manage/category")
public class ProductCategoryManageController extends BaseController{
//	@Autowired
//    private IUserService iUserService;
    @Autowired
    private IProductCategoryService iCategoryService;

    @RequestMapping("getCategory.do")
    @ResponseBody
    public ServerResponse getChildrenParallelCategory(HttpSession session, @RequestParam(value="categoryId", defaultValue = "0")Integer categoryId) {
//        User user = (User) session.getAttribute(Constants.CURRENT_USER);
//        if(user == null) {
//            return ServerResponse.createByErrorCodeMsg(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录");
//        }
//        if(iUserService.checkAdminRole(user).isSuccess()) {
            //查询子节点的category信息,并且不递归
            return iCategoryService.getChildrenParallelCategory(categoryId);
//        } else {
//            return ServerResponse.createByErrorMsg("无权限操作,需要管理权限");
//        }
    }

    @RequestMapping("getDeepCategory.do")
    @ResponseBody
    public ServerResponse getDeepCategory(HttpSession session, @RequestParam(value="categoryId", defaultValue = "0")Integer categoryId) {
//        User user = (User) session.getAttribute(Constants.CURRENT_USER);
//        if(user == null) {
//            return ServerResponse.createByErrorCodeMsg(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录");
//        }
//        if(iUserService.checkAdminRole(user).isSuccess()) {
            //查询当前节点的id 和递归子节点id
            return iCategoryService.selectCategoryAndChildrenById(categoryId);
//        } else {
//            return ServerResponse.createByErrorMsg("无权限操作,需要管理权限");
//        }
    }

    @RequestMapping("addCategory.do")
    @ResponseBody
    public ServerResponse addCategory(HttpSession session, String categoryname, @RequestParam(value="parentId", defaultValue = "0")int parentId) {
//        User user = (User) session.getAttribute(Constants.CURRENT_USER);
//        if(user == null) {
//            return ServerResponse.createByErrorCodeMsg(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录");
//        }
//        //校验是否是管理员
//        if(iUserService.checkAdminRole(user).isSuccess()) {
            return iCategoryService.addCategory(getSessionStaff(), categoryname, parentId);
//        } else {
//            return ServerResponse.createByErrorMsg("无权限操作,需要管理权限");
//        }
    }

    @RequestMapping("setCategoryName.do")
    @ResponseBody
    public ServerResponse setCategoryName(HttpSession session, Integer categoryId, String categoryName) {
//        User user = (User) session.getAttribute(Constants.CURRENT_USER);
//        if(user == null) {
//            return ServerResponse.createByErrorCodeMsg(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请登录");
//        }
//        //校验是否是管理员
//        if(iUserService.checkAdminRole(user).isSuccess()) {
            return iCategoryService.updateCategoryName(getSessionStaff(), categoryId, categoryName);
//        } else {
//            return ServerResponse.createByErrorMsg("无权限操作,需要管理权限");
//        }
    }
}
