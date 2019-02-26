package com.carlab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlab.common.ServerResponse;
import com.carlab.db.Staff;
import com.carlab.mapper.StaffMapper;
import com.carlab.service.IStaffService;
import com.carlab.utils.CarlabHelper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("iStaffService")
public class StaffServiceImpl implements IStaffService{
	@Autowired
	private StaffMapper staffMapper;
	
	public ServerResponse<Staff> query(String id) {
		Staff staff = staffMapper.selectByPrimaryKey(id);
		if(staff == null)
			return ServerResponse.createByErrorMsg("staff not found, id not exist");
		return ServerResponse.createBySuccess(staff);
	} 
	
	public ServerResponse<Staff> login(String username, String password) {
		Staff staff = staffMapper.login(username, CarlabHelper.encriptPassword(password));
		if(staff == null)
			return ServerResponse.createByErrorMsg("login fail, username or password incorrect");
		return ServerResponse.createBySuccess(staff);
	} 
	
	public ServerResponse save(Staff staff) {
		if(staffMapper.insertSelective(staff)>0)
			return ServerResponse.createBySuccess();
		else 
			return ServerResponse.createByErrorMsg("register staff fail");
	}
	
	public ServerResponse<PageInfo> selectByPageNumAndPageSize(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Staff> list = staffMapper.selectAll();
		return ServerResponse.createBySuccess(new PageInfo(list));
	}
	
	public ServerResponse update(Staff staff) {
		if(staffMapper.updateByPrimaryKeySelective(staff)>0)
			return ServerResponse.createBySuccess();
		else 
			return ServerResponse.createByErrorMsg("update fail");
	}
	
	public ServerResponse changePassword(String id, String oldPass, String newPass) {
		if(staffMapper.selectByKeyAndPass(id, CarlabHelper.encriptPassword(oldPass)) != null) {
			staffMapper.updateByPrimaryKeySelective(CarlabHelper.assembleStaff4ChangePassword(id, newPass));
			return ServerResponse.createBySuccess();
		} else 
			return ServerResponse.createByErrorMsg("update fail");
	}
}
