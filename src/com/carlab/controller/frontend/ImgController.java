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
@RequestMapping(value="/img")
public class ImgController extends BaseController {
	private final static String uploadPath = "/Users/gemini9640/Documents/work/uploadFiles/";
	@Autowired
	private MultipartResolver multipartResolver;
	@Autowired
	private IUserCarService iUserCarService;
	
	@RequestMapping(value="/upload/carImg")
	@ResponseBody
	public ServerResponse uploadCarImg(HttpSession session, MultipartHttpServletRequest request, Integer userCarId){
		List<UserCarPicture> userCarPictures;
		try {
			userCarPictures = ImageUtil.uploadImageByIOStream(request, uploadPath);
			if(userCarPictures != null && !userCarPictures.isEmpty()) {
				if(userCarId == null)
					//第一次上传图片没有userCarId
					return iUserCarService.saveUserCarAndPicture(getSessionCustomer().getUsername(), userCarPictures);
				else 
					return iUserCarService.saveUserCarPicture(userCarId, userCarPictures);
			} 
			return ServerResponse.createByErrorMsg("upload fail");
		} catch (UploadImgException ue) {
			ue.printStackTrace();
			return ServerResponse.createByErrorMsg(ue.getMessage());
		} catch (IOException ioe) {
			ioe.printStackTrace();
			return ServerResponse.createByErrorMsg(ioe.getMessage());
		}
	}
	
	@RequestMapping(value="/showByPath.do")
	@ResponseBody
	public void showByPath(String path) {
		try{
			String filePath = uploadPath+path;
			getResponse().setHeader("Pragma", "No-cache");
			getResponse().setHeader("Cache-Control", "no-cache");
			getResponse().setDateHeader("Expires", 0);
			getResponse().setHeader("content-type", "image/jpeg");
			ImageUtil.showByIOStream(filePath, getResponse().getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(getResponse().getOutputStream() != null) {
					getResponse().getOutputStream().flush();
					getResponse().getOutputStream().close();
					getResponse().flushBuffer();
				}
			} catch (IOException e) {
				e.printStackTrace();
				responseWriter("error");
			}
		}
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}
}
