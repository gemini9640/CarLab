package com.carlab.controller.backend;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carlab.common.Constants;
import com.carlab.common.ServerResponse;
import com.carlab.db.Merchant;
import com.carlab.db.vo.MerchantQuickLookVo;
import com.carlab.enums.ResponseCode;
import com.carlab.service.IMerchantService;
import com.carlab.utils.StringUtils;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/manage/merchant")
public class MerchantManageController {
	@Autowired
    private IMerchantService iMerchantService;
	
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Merchant> login(String username, String password) {
		if(StringUtils.isEmpty(username)) 
			return ServerResponse.createByErrorMsg("username is required");
		if(StringUtils.isEmpty(password)) 
			return ServerResponse.createByErrorMsg("password is required");
        return iMerchantService.login(username, password);
    }
	
	@RequestMapping(value = "add.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse add(Merchant merchant) {
		if(StringUtils.isEmpty(merchant.getUsername()))
			return ServerResponse.createByErrorMsg("username cannot be empty");
		if(StringUtils.isEmpty(merchant.getPassword()))
			return ServerResponse.createByErrorMsg("password cannot be empty");
		if(StringUtils.isEmpty(merchant.getFullName()))
			return ServerResponse.createByErrorMsg("full name cannot be empty");
		if(StringUtils.isEmpty(merchant.getEmail()))
			return ServerResponse.createByErrorMsg("email cannot be empty");
		if(StringUtils.isEmpty(merchant.getCompany()))
			return ServerResponse.createByErrorMsg("company cannot be empty");
		if(StringUtils.isEmpty(merchant.getPhone()))
			return ServerResponse.createByErrorMsg("phone cannot be empty");
		if(StringUtils.isEmpty(merchant.getGender()))
			return ServerResponse.createByErrorMsg("gender cannot be empty");
		if(StringUtils.isEmpty(merchant.getIc()))
			return ServerResponse.createByErrorMsg("IC cannot be empty");
		if(StringUtils.isEmpty(merchant.getRole()))
			return ServerResponse.createByErrorMsg("must assign a role");
		merchant.setCreateTime(new Date());
		merchant.setFlag(Constants.Flag.ENABLE);
        return iMerchantService.save(merchant);
    }
	
	@RequestMapping(value = "edit.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse edit(Merchant merchant) {
		if(StringUtils.isEmpty(merchant.getId()))
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ILLIGAL_ARGUMENT.getCode(), ResponseCode.ILLIGAL_ARGUMENT.getDesc());
        return iMerchantService.update(merchant);
    }
	
	@RequestMapping(value = "info.do", method = RequestMethod.POST)
    public ServerResponse<Merchant> edit(String id) {
		if(StringUtils.isEmpty(id))
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ILLIGAL_ARGUMENT.getCode(), ResponseCode.ILLIGAL_ARGUMENT.getDesc());
        return iMerchantService.query(id);
    }
	
	@RequestMapping(value = "list.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<PageInfo> list(@RequestParam(value="pageNum", defaultValue = "1")Integer pageNum, 
    										@RequestParam(value="pageSize", defaultValue = "5")Integer pageSize) {
        return iMerchantService.selectByPageNumAndPageSize(pageNum, pageSize);
    }
	
	@RequestMapping(value = "quickLookList.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse<List<MerchantQuickLookVo>> quickLookList() {
		return iMerchantService.quickLookList();
	}
	
	@RequestMapping(value = "updateQuickLookMerchant.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse updateQuickLookMerchant(@RequestParam(value="id")String id, @RequestParam(value="flag", defaultValue = "0")Integer flag) {
		if(StringUtils.isEmpty(id)) 
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ILLIGAL_ARGUMENT.getCode(), ResponseCode.ILLIGAL_ARGUMENT.getDesc());
		Merchant merchant = new Merchant();
		merchant.setId(id);
		merchant.setFlag(flag);
		merchant.setUpdateTime(new Date());
		return iMerchantService.update(merchant);
	}
}
