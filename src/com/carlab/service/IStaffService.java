package com.carlab.service;

import com.carlab.common.ServerResponse;
import com.carlab.db.Customer;
import com.carlab.db.Staff;
import com.github.pagehelper.PageInfo;

public interface IStaffService {
	public ServerResponse<Staff> query(String id);
	public ServerResponse<Staff> login(String username, String password);
	public ServerResponse save(Staff staff);
	public ServerResponse<PageInfo> selectByPageNumAndPageSize(Integer pageNum, Integer pageSize);
	public ServerResponse update(Staff staff);
	public ServerResponse changePassword(String id, String oldPass, String newPass);
}
