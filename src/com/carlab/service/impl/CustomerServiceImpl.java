package com.carlab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlab.common.ServerResponse;
import com.carlab.db.Customer;
import com.carlab.db.Staff;
import com.carlab.mapper.CustomerMapper;
import com.carlab.service.ICustomerService;
import com.carlab.utils.CarlabHelper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("iCustomerService")
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private CustomerMapper customerMapper;

	public ServerResponse<Customer> query(String id) {
		Customer customer = customerMapper.selectByPrimaryKey(id);
		if(customer == null)
			return ServerResponse.createByErrorMsg("user not found, id not exist");
		return ServerResponse.createBySuccess(customer);
	} 
	
	public ServerResponse<Customer> login(String username, String password) {
		Customer customer = customerMapper.login(username, CarlabHelper.encriptPassword(password));
		if(customer == null)
			return ServerResponse.createByErrorMsg("login fail, username or password incorrect");
		return ServerResponse.createBySuccess(customer);
	} 
	
	public ServerResponse<Customer> save(Customer customer) {
		if(customerMapper.insertSelective(customer)>0)
			return ServerResponse.createBySuccess(customer);
		else 
			return ServerResponse.createByErrorMsg("register fail, please contect customer service");
	}
	
	public ServerResponse<PageInfo> selectByPageNumAndPageSize(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Customer> list = customerMapper.selectAll();
		return ServerResponse.createBySuccess(new PageInfo(list));
	}
	
	public ServerResponse update(Customer customer) {
		if(customerMapper.updateByPrimaryKeySelective(customer)>0)
			return ServerResponse.createBySuccess();
		else 
			return ServerResponse.createByErrorMsg("update fail");
	}
	
	public ServerResponse changePassword(String id, String oldPass, String newPass) {
		if(customerMapper.selectByKeyAndPass(id, CarlabHelper.encriptPassword(oldPass)) != null) {
			customerMapper.updateByPrimaryKeySelective(CarlabHelper.assembleCustomer4ChangePassword(id, newPass));
			return ServerResponse.createBySuccess();
		} else 
			return ServerResponse.createByErrorMsg("update fail");
	}
}
