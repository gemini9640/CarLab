package com.carlab.service;

import com.carlab.common.ServerResponse;
import com.carlab.db.Customer;
import com.github.pagehelper.PageInfo;

public interface ICustomerService {
	public ServerResponse<Customer> query(String id);
	public ServerResponse<Customer> login(String username, String password);
	public ServerResponse<Customer> save(Customer customer);
	public ServerResponse<PageInfo> selectByPageNumAndPageSize(Integer pageNum, Integer pageSize);
	public ServerResponse update(Customer customer);
	public ServerResponse changePassword(String id, String oldPass, String newPass);
}
