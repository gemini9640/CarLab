package com.carlab.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.carlab.db.Merchant;
import com.carlab.db.vo.MerchantQuickLookVo;

public interface MerchantMapper {
    int deleteByPrimaryKey(String id);

    int insert(Merchant record);

    int insertSelective(Merchant record);

    Merchant selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Merchant record);

    int updateByPrimaryKey(Merchant record);
    
    //new
    List<Merchant> selectAll();
    
    Merchant selectByKeyAndPass(@Param("id")String id, @Param("password")String password);
    
    Merchant login(@Param("username")String id, @Param("password")String password);
    
    List<MerchantQuickLookVo> quickLookList(); 
}