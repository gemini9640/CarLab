package com.carlab.controller.backend;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carlab.common.Constants;
import com.carlab.common.ServerResponse;
import com.carlab.db.Staff;
import com.carlab.enums.ResponseCode;
import com.carlab.service.IStaffService;
import com.carlab.utils.StringUtils;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/manage/staff")
public class StaffManageController {
	@Autowired
    private IStaffService iStaffService;
	
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Staff> login(String username, String password) {
		if(StringUtils.isEmpty(username)) 
			return ServerResponse.createByErrorMsg("username is required");
		if(StringUtils.isEmpty(password)) 
			return ServerResponse.createByErrorMsg("password is required");
        return iStaffService.login(username, password);
    }
	
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse add(Staff staff) {
		if(StringUtils.isEmpty(staff.getUsername()))
			return ServerResponse.createByErrorMsg("username cannot be empty");
		if(StringUtils.isEmpty(staff.getPassword()))
			return ServerResponse.createByErrorMsg("password cannot be empty");
		if(StringUtils.isEmpty(staff.getFullName()))
			return ServerResponse.createByErrorMsg("full name cannot be empty");
		if(StringUtils.isEmpty(staff.getEmail()))
			return ServerResponse.createByErrorMsg("email cannot be empty");
		if(StringUtils.isEmpty(staff.getRole()))
			return ServerResponse.createByErrorMsg("must assign a role");
		staff.setCreateTime(new Date());
		staff.setFlag(Constants.Flag.ENABLE);
        return iStaffService.save(staff);
    }
	
	@RequestMapping(value = "edit.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse edit(Staff staff) {
		if(StringUtils.isEmpty(staff.getId()))
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ILLIGAL_ARGUMENT.getCode(), ResponseCode.ILLIGAL_ARGUMENT.getDesc());
        return iStaffService.update(staff);
    }
	
	@RequestMapping(value = "info.do", method = RequestMethod.POST)
    public ServerResponse<Staff> edit(String id) {
		if(StringUtils.isEmpty(id))
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ILLIGAL_ARGUMENT.getCode(), ResponseCode.ILLIGAL_ARGUMENT.getDesc());
        return iStaffService.query(id);
    }
	
	@RequestMapping(value = "list.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo> list(@RequestParam(value="pageNum", defaultValue = "1")Integer pageNum, 
    										@RequestParam(value="pageSize", defaultValue = "5")Integer pageSize) {
        return iStaffService.selectByPageNumAndPageSize(pageNum, pageSize);
    }
}
