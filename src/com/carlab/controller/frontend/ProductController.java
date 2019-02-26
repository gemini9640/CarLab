package com.carlab.controller.frontend;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carlab.common.ServerResponse;
import com.carlab.service.IProductService;
import com.carlab.vo.ProductDetailVo;

@Controller
@RequestMapping("/product")
public class ProductController {
//	@Autowired
//    private IUserService iUserService;
    @Autowired
    private IProductService iProductService;

    @RequestMapping(value = "detail.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<ProductDetailVo> detail(HttpSession session, Integer productId) {
    		return iProductService.getProductDetailVoById(productId);
    }
}
