package com.carlab.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.carlab.db.BookingItem;
import com.carlab.db.vo.BookingBriefVo;
import com.carlab.db.vo.SalesVo;

public interface BookingItemMapper {
	int deleteByPrimaryKey(Integer id);

    int insert(BookingItem record);

    int insertSelective(BookingItem record);

    BookingItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookingItem record);

    int updateByPrimaryKey(BookingItem record);
    
    int batchInsertForNew(List<BookingItem> items);
    
    List<BookingItem> selectByPrimaryKeys(@Param("ids")List<Integer> ids);
    
    List<BookingItem> selectByDate(@Param("start")Date start, @Param("end")Date end);
    
    List<SalesVo> selectSalesSummarized(@Param("start")Date start, @Param("end")Date end);
    
    List<BookingBriefVo> selectBookingItemBrief(@Param("start")Date start, @Param("end")Date end);
}