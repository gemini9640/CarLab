package com.carlab.controller.backend;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carlab.common.ServerResponse;
import com.carlab.controller.base.BaseController;
import com.carlab.db.Product;
import com.carlab.service.IProductService;

@Controller
@RequestMapping("/manage/product")
public class ProductManageController extends BaseController{
//	@Autowired
//    private IUserService iUserService;
    @Autowired
    private IProductService iProductService;

    @RequestMapping(value = "save.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse productSave(HttpSession session, Product product) {
//        User user = (User) session.getAttribute(Constants.CURRENT_USER);
//        if(user == null) {
//            return ServerResponse.createByErrorCodeMsg(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请先登陆");
//        }
//
//        //判断管理员权限
//        if(iUserService.checkAdminRole(user).isSuccess()) {
            return iProductService.saveOrUpdateProduct(getSessionStaff(), product);
//        } else {
//            return ServerResponse.createByErrorMsg("无权限操作");
//        }
    }

    //产品上下架
    @RequestMapping(value = "setSaleStatus.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> setSaleStatus(HttpSession session, Integer productId, Integer status) {
//        User user = (User) session.getAttribute(Constants.CURRENT_USER);
//        if(user == null) {
//            return ServerResponse.createByErrorCodeMsg(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请先登陆");
//        }
//
//        //判断管理员权限
//        if(iUserService.checkAdminRole(user).isSuccess()) {
            return iProductService.setSaleStatus(getSessionStaff(), productId,status);
//        } else {
//            return ServerResponse.createByErrorMsg("无权限操作");
//        }
    }

    //产品详情
    @RequestMapping(value = "getProductDetail.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getProductDetail(HttpSession session, Integer productId) {
//        User user = (User) session.getAttribute(Constants.CURRENT_USER);
//        if(user == null) {
//            return ServerResponse.createByErrorCodeMsg(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请先登陆");
//        }
//
//        //判断管理员权限
//        if(iUserService.checkAdminRole(user).isSuccess()) {
            return iProductService.getProductDetailVoById(productId);
//        } else {
//            return ServerResponse.createByErrorMsg("无权限操作");
//        }
    }

    //产品列表(动态分页)
    @RequestMapping(value = "list.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getList(HttpSession session, Integer pageNum, Integer pageSize) {
//        User user = (User) session.getAttribute(Constants.CURRENT_USER);
//        if(user == null) {
//            return ServerResponse.createByErrorCodeMsg(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请先登陆");
//        }
//
//        //判断管理员权限
//        if(iUserService.checkAdminRole(user).isSuccess()) {
            return iProductService.getList(pageNum, pageSize);
//        } else {
//            return ServerResponse.createByErrorMsg("无权限操作");
//        }
    }

    //产品搜索(动态分页)
    @RequestMapping(value = "search.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse searchproduct(HttpSession session, String productName, String productId, Integer pageNum, Integer pageSize) {
//        User user = (User) session.getAttribute(Constants.CURRENT_USER);
//        if(user == null) {
//            return ServerResponse.createByErrorCodeMsg(ResponseCode.NEED_LOGIN.getCode(),"用户未登录,请先登陆");
//        }
//
//        //判断管理员权限
//        if(iUserService.checkAdminRole(user).isSuccess()) {
            return iProductService.searchProduct(productName, productId, pageNum, pageSize);
//        } else {
//            return ServerResponse.createByErrorMsg("无权限操作");
//        }
    }
}
