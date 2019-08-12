package com.carlab.controller.backend;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/home")
public class HomeController {
	
	@RequestMapping(value="/catelog/product_add.htm")
	public ModelAndView product_add(){
		return new ModelAndView("/WEB-INF/jsp/catelog/product_detail");
	}
	
	@RequestMapping(value="/catelog/product_detail.htm")
	public ModelAndView product_detail(){
		return new ModelAndView("/WEB-INF/jsp/catelog/product_detail");
	}
	
	@RequestMapping(value="/catelog/product_list.htm")
	public ModelAndView product_list(){
		return new ModelAndView("/WEB-INF/jsp/catelog/product_list");
	}
	
	@RequestMapping(value="/catelog/category_add.htm")
	public ModelAndView category_add(){
		return new ModelAndView("/WEB-INF/jsp/catelog/category_detail");
	}
	
	@RequestMapping(value="/catelog/category_detail.htm")
	public ModelAndView category_detail(){
		return new ModelAndView("/WEB-INF/jsp/catelog/category_detail");
	}
	
	@RequestMapping(value="/catelog/category_list.htm")
	public ModelAndView category_list(){
		return new ModelAndView("/WEB-INF/jsp/catelog/category_list");
	}
	
	
	
	@RequestMapping(value="/user/merchant_add.htm")
	public ModelAndView merchant_add(){
		return new ModelAndView("/WEB-INF/jsp/user/merchant_detail");
	}
	
	@RequestMapping(value="/user/merchant_detail.htm")
	public ModelAndView merchant_detail(){
		return new ModelAndView("/WEB-INF/jsp/user/merchant_detail");
	}
	
	@RequestMapping(value="/user/merchant_list.htm")
	public ModelAndView merchant_list(){
		return new ModelAndView("/WEB-INF/jsp/user/merchant_list");
	}
	
	@RequestMapping(value="/user/staff_add.htm")
	public ModelAndView staff_add(){
		return new ModelAndView("/WEB-INF/jsp/user/staff_detail");
	}
	
	@RequestMapping(value="/user/staff_detail.htm")
	public ModelAndView staff_detail(){
		return new ModelAndView("/WEB-INF/jsp/user/staff_detail");
	}
	
	@RequestMapping(value="/user/staff_list.htm")
	public ModelAndView staff_list(){
		return new ModelAndView("/WEB-INF/jsp/user/staff_list");
	}
	
	@RequestMapping(value="/user/sales_staff_add.htm")
	public ModelAndView sales_staff_add(){
		return new ModelAndView("/WEB-INF/jsp/user/sales_staff_detail");
	}
	
	@RequestMapping(value="/user/sales_staff_detail.htm")
	public ModelAndView sales_staff_detail(){
		return new ModelAndView("/WEB-INF/jsp/user/sales_staff_detail");
	}
	
	@RequestMapping(value="/user/sales_staff_list.htm")
	public ModelAndView sales_staff_list(){
		return new ModelAndView("/WEB-INF/jsp/user/sales_staff_list");
	}
}
