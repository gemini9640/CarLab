package com.carlab.controller.frontend;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;

import com.carlab.common.Constants;
import com.carlab.common.ServerResponse;
import com.carlab.controller.base.BaseController;
import com.carlab.db.Customer;
import com.carlab.db.UserCarPicture;
import com.carlab.enums.ResponseCode;
import com.carlab.exception.UploadImgException;
import com.carlab.service.IUserCarService;
import com.carlab.utils.ImageUtil;


@Controller
@RequestMapping(value="/date")
public class DateTimeController extends BaseController {
	@Autowired
	private IUserCarService iUserCarService;
	
//	@RequestMapping(value="/upload")
//	@ResponseBody
//	public ServerResponse upload(HttpSession session, MultipartHttpServletRequest request){
//	}
}
