package com.carlab.controller.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carlab.common.ServerResponse;
import com.carlab.db.Customer;
import com.carlab.enums.ResponseCode;
import com.carlab.service.ICustomerService;
import com.carlab.service.IUserCarService;
import com.carlab.vo.UserCarVo;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/manage/customer")
public class CustomerManageController {
	@Autowired
    private ICustomerService iCustomerService;
	@Autowired
	private IUserCarService iUserCarService;
	
	@RequestMapping(value = "list.do", method = RequestMethod.POST)
    @ResponseBody 
    public ServerResponse<PageInfo> list(@RequestParam(value="pageNum", defaultValue = "1")Integer pageNum, 
    										@RequestParam(value="pageSize", defaultValue = "5")Integer pageSize) {
		ServerResponse<PageInfo> response = iCustomerService.selectByPageNumAndPageSize(pageNum, pageSize);
//		PageInfo info =  (PageInfo) response.getData();
//		List list =  info.getList();
//		for (Object object : list) {
//			Customer c = (Customer) object;
//			System.out.println(c);
//		}
		return response;
    }
	
	@RequestMapping(value = "car/info.do", method = RequestMethod.POST)
    @ResponseBody
	public ServerResponse<UserCarVo> infoCar(Integer carId) {
		if(carId == null) 
			return ServerResponse.createByErrorCodeMsg(ResponseCode.ILLIGAL_ARGUMENT.getCode(), ResponseCode.ILLIGAL_ARGUMENT.getDesc());
		return iUserCarService.queryUserCarInfo(carId);
	}
}
