package com.carlab.service;

import java.util.List;

import com.carlab.common.ServerResponse;
import com.carlab.db.Customer;
import com.carlab.db.Merchant;
import com.carlab.db.Staff;
import com.carlab.db.vo.MerchantQuickLookVo;
import com.github.pagehelper.PageInfo;

public interface IMerchantService {
	public ServerResponse<Merchant> query(String id);
	public ServerResponse<Merchant> login(String username, String password);
	public ServerResponse save(Merchant merchant);
	public ServerResponse<PageInfo> selectByPageNumAndPageSize(Integer pageNum, Integer pageSize);
	public ServerResponse update(Merchant merchant);
	public ServerResponse changePassword(String id, String oldPass, String newPass);
	public ServerResponse<List<MerchantQuickLookVo>>  quickLookList();
}
