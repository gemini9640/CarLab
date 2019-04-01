package com.carlab.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carlab.common.ServerResponse;
import com.carlab.db.Merchant;
import com.carlab.db.vo.MerchantQuickLookVo;
import com.carlab.mapper.MerchantMapper;
import com.carlab.service.IMerchantService;
import com.carlab.utils.CarlabHelper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("iMerchantService")
public class MerchantServiceImpl implements IMerchantService{
	@Autowired
	private MerchantMapper merchantMapper;
	
	public ServerResponse<Merchant> query(String id) {
		Merchant merchant = merchantMapper.selectByPrimaryKey(id);
		if(merchant == null)
			return ServerResponse.createByErrorMsg("staff not found, id not exist");
		return ServerResponse.createBySuccess(merchant);
	} 
	
	public ServerResponse<Merchant> login(String username, String password) {
		Merchant merchant = merchantMapper.login(username, CarlabHelper.encriptPassword(password));
		if(merchant == null)
			return ServerResponse.createByErrorMsg("login fail, username or password incorrect");
		return ServerResponse.createBySuccess(merchant);
	} 
	
	public ServerResponse save(Merchant merchant) {
		if(merchantMapper.insertSelective(merchant)>0)
			return ServerResponse.createBySuccess();
		else 
			return ServerResponse.createByErrorMsg("register staff fail");
	}
	
	public ServerResponse<PageInfo> selectByPageNumAndPageSize(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Merchant> list = merchantMapper.selectAll();
		return ServerResponse.createBySuccess(new PageInfo(list));
	}
	
	public ServerResponse update(Merchant merchant) {
		if(merchantMapper.updateByPrimaryKeySelective(merchant)>0)
			return ServerResponse.createBySuccess();
		else 
			return ServerResponse.createByErrorMsg("update fail");
	}
	
	public ServerResponse changePassword(String id, String oldPass, String newPass) {
		if(merchantMapper.selectByKeyAndPass(id, CarlabHelper.encriptPassword(oldPass)) != null) {
			merchantMapper.updateByPrimaryKeySelective(CarlabHelper.assembleMerchant4ChangePassword(id, newPass));
			return ServerResponse.createBySuccess();
		} else 
			return ServerResponse.createByErrorMsg("update fail");
	}
	
	public ServerResponse<List<MerchantQuickLookVo>>  quickLookList() {
		return ServerResponse.createBySuccess(merchantMapper.quickLookList());
	}
}
