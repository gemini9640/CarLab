package com.carlab.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.carlab.db.Staff;

public interface StaffMapper {
    int deleteByPrimaryKey(String id);

    int insert(Staff record);

    int insertSelective(Staff record);

    Staff selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Staff record);

    int updateByPrimaryKey(Staff record);
    
    //new
    List<Staff> selectAll();
    
    Staff selectByKeyAndPass(@Param("id")String id, @Param("password")String password);
    
    Staff login(@Param("username")String id, @Param("password")String password);
}