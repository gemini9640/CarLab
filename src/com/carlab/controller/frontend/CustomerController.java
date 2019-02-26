package com.carlab.controller.frontend;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carlab.common.ServerResponse;
import com.carlab.controller.base.BaseController;
import com.carlab.db.Customer;
import com.carlab.enums.ResponseCode;
import com.carlab.service.ICustomerService;
import com.carlab.service.IUserCarService;
import com.carlab.utils.CarlabHelper;
import com.carlab.utils.DateUtil;
import com.carlab.utils.StringUtils;
import com.carlab.vo.UserCarVo;

@Controller
@RequestMapping("/customer")
public class CustomerController extends BaseController{
	@Autowired
    private ICustomerService iCustomerService;
	@Autowired
	private IUserCarService iUserCarService;
	
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Customer> login(Map<String, String> map) {
		String username = map.get("username");
		String password = map.get("password");
		
		if(StringUtils.isEmpty(username)) 
			return ServerResponse.createByErrorMsg("username is required");
		if(StringUtils.isEmpty(password)) 
			return ServerResponse.createByErrorMsg("password is required");
        return iCustomerService.login(username, password);
    }
	
	@RequestMapping(value = "register.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Customer> register(Map<String, String> map) {
		String username = map.get("username");
		String password = map.get("password");
		String fullName = map.get("fullName");
		String email = map.get("email");
		String birthdayStr = map.get("birthday");
		String gender = map.get("gender");
		String phone = map.get("phone");
		String address = map.get("address");
		String referalId = map.get("referalId");
		
		if(StringUtils.isEmpty(username)) 
			return ServerResponse.createByErrorMsg("username is required");
		if(StringUtils.isEmpty(password)) 
			return ServerResponse.createByErrorMsg("password is required");
		if(StringUtils.isEmpty(fullName)) 
			return ServerResponse.createByErrorMsg("fullName is required");
		Date birthday = null;
		if(StringUtils.isEmpty(birthdayStr)) 
			return ServerResponse.createByErrorMsg("birthday is required");
		else 
			birthday = DateUtil.fomatDate(birthdayStr);
		if(StringUtils.isEmpty(gender)) 
			return ServerResponse.createByErrorMsg("gender is required");
		if(StringUtils.isEmpty(phone)) 
			return ServerResponse.createByErrorMsg("phone is required");
		if(StringUtils.isEmpty(address)) 
			return ServerResponse.createByErrorMsg("address is required");
		
		Customer costomer = CarlabHelper.assembleCustomer4Register(username, password, fullName, email, birthday, gender, phone, address, referalId);
        return iCustomerService.save(costomer);
    }
	
	@RequestMapping(value = "edit.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse edit(Map<String, String> map) {
		String id = map.get("id");
		if(StringUtils.isEmpty(id)) 
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ILLIGAL_ARGUMENT.getCode(), ResponseCode.ILLIGAL_ARGUMENT.getDesc());
		String fullName = map.get("fullName");
		String email = map.get("email");
		String phone = map.get("phone");
		String address = map.get("address");
		Customer costomer = CarlabHelper.assembleCustomer4Edit(id, fullName, email, phone, address);
        return iCustomerService.update(costomer);
    }
	
	@RequestMapping(value = "chnPass.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse changePassword(Map<String, String> map) {
		String id = map.get("id");
		if(StringUtils.isEmpty(id)) 
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ILLIGAL_ARGUMENT.getCode(), ResponseCode.ILLIGAL_ARGUMENT.getDesc());
		String oldP= map.get("old");
		String newP = map.get("new");
		String confirmP = map.get("confirm");
		if(StringUtils.isEmpty(oldP)) 
			return ServerResponse.createByErrorMsg("old password is required");
		if(StringUtils.isEmpty(newP)) 
			return ServerResponse.createByErrorMsg("new password is required");
		if(!StringUtils.equals(newP, confirmP)) 
			return ServerResponse.createByErrorMsg("confirm password is not the same with your new password");
        return iCustomerService.changePassword(id, oldP, newP);
    }
	
	/**
	 * 用户保存车信息时会先上传图片才提交信息表单，上传图片的时候系统已经创建了图片的ID和车信息ID，
	 * 客户提交表单的时候其实只是更新在已生成的ID基础上更新其他信息
	 */
	@RequestMapping(value = "car/update.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse updateCar(Map<String, String> map) {
		//必须先上传图片才可以提交，上传图片系统会自动生成carId
		String carId = map.get("carId");
		if(StringUtils.isEmpty(carId)) 
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ILLIGAL_ARGUMENT.getCode(), ResponseCode.ILLIGAL_ARGUMENT.getDesc());
		String plate= map.get("plate");
		String model = map.get("model");
		String manufacturedDate = map.get("manufacturedDate");
		
		StringBuilder sb = new StringBuilder();
		sb.append("plate: ").append(plate).append(", ")
		  .append("model: ").append(model).append(", ")
		  .append("manufactured date: ").append(manufacturedDate).append(".");
        return iUserCarService.updateUserCar(getSessionCustomer().getId(), Integer.parseInt(carId), sb.toString());
    }
	
	@RequestMapping(value = "car/info.do", method = RequestMethod.POST)
    @ResponseBody
	public ServerResponse<UserCarVo> infoCar(Integer carId) {
		if(carId == null) 
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ILLIGAL_ARGUMENT.getCode(), ResponseCode.ILLIGAL_ARGUMENT.getDesc());
		return iUserCarService.queryUserCarInfo(carId);
	}
}
