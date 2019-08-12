package com.carlab.controller.backend;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carlab.common.ServerResponse;
import com.carlab.controller.base.BaseController;
import com.carlab.db.BookingItem;
import com.carlab.service.IBookingService;
import com.carlab.utils.CarlabHelper;
import com.carlab.utils.DateUtils;
import com.carlab.utils.StringUtils;
import com.carlab.vo.BookingDetailVo;
import com.carlab.db.vo.BookingBriefVo;
import com.carlab.db.vo.SalesVo;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/manage/booking")
public class BookingManageController extends BaseController{
//	@Autowired
//    private IUserService iUserService;
    @Autowired
    private IBookingService iBookingService;
//
//    @RequestMapping(value = "item/create.do", method = RequestMethod.POST)
//    @ResponseBody
//    public ServerResponse<BookingItem> createBookingItem(Map<String, String> map) {
//    		String bookingItemIdStr = map.get("bookingItemId");
//    		String productId = map.get("productId");
//    		String bookingTimeStr = map.get("bookingTime");
//    		if(StringUtils.isEmpty(productId))
//    			return ServerResponse.createByErrorMsg("merchant agent is required");
//    		if(StringUtils.isEmpty(bookingTimeStr))
//    			return ServerResponse.createByErrorMsg("booking time is required");
//    		Date bookingTime = DateUtils.parseDateForStandard(bookingTimeStr);
//        return iBookingService.confirmBookingItem(getSessionStaff(), Integer.getInteger(bookingItemIdStr), Integer.getInteger(productId), bookingTime);
//    }
    
    @RequestMapping(value = "item/confirm.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<BookingItem> confirmBookingItem(Map<String, String> map) {
    		String bookingItemIdStr = map.get("bookingItemId");
    		String productId = map.get("productId");
    		String bookingTimeStr = map.get("bookingTime");
    		String userCarIdStr = map.get("userCarId");
    		String otherChargeStr = map.get("otherCharge");
    		String otherChargeInfo = map.get("otherChargeInfo");
    		
    		if(StringUtils.isEmpty(productId))
    			return ServerResponse.createByErrorMsg("merchant agent is required");
    		
    		if(StringUtils.isEmpty(bookingTimeStr))
    			return ServerResponse.createByErrorMsg("booking time is required");
    		Date bookingTime = DateUtils.parseDateRemoteDetails(bookingTimeStr);
    		
    		Integer userCarId = null;
    		if(StringUtils.isNotEmpty(userCarIdStr))
    			userCarId = Integer.getInteger(userCarIdStr);

    		BigDecimal otherCharge = null;
    		if(StringUtils.isEmpty(otherChargeStr) && StringUtils.isNotEmpty(otherChargeInfo))
    			return ServerResponse.createByErrorMsg("must enter other charge price");
    		else if(StringUtils.isNotEmpty(otherChargeStr) && StringUtils.isEmpty(otherChargeInfo))
    			return ServerResponse.createByErrorMsg("must specify other charge info");
    		else if(StringUtils.isNotEmpty(otherChargeStr) && StringUtils.isNotEmpty(otherChargeStr))
    			otherCharge = BigDecimal.valueOf(Double.parseDouble(otherChargeStr));
        return iBookingService.confirmBookingItem(getSessionStaff(), Integer.valueOf(bookingItemIdStr), Integer.getInteger(productId), userCarId, otherCharge, otherChargeInfo, bookingTime);
    }
    
    @RequestMapping(value = "confirm.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<BookingDetailVo> confirmBooking(Map<String, String> map) {
	    	String bookingIdStr = map.get("bookingId");	
	    	String bookingItemIdsStr = map.get("bookingItemIds");
    		String outdoorChargeStr = map.get("outdoorCharge");
    		
    		if(StringUtils.isEmpty(bookingIdStr))
    			return ServerResponse.createByErrorMsg("bookingNo is required");
    		if(StringUtils.isEmpty(bookingItemIdsStr))
    			return ServerResponse.createByErrorMsg("bookingItem is required");
    		
    		Integer outdoorCharge = null;
    		if(StringUtils.isNotEmpty(outdoorChargeStr))
    			outdoorCharge = Integer.valueOf(outdoorChargeStr);
    		return iBookingService.confirmBooking(getSessionStaff(), Integer.valueOf(bookingIdStr), CarlabHelper.string2Integerlist(bookingItemIdsStr), outdoorCharge);
    }
    
    @RequestMapping(value = "sales.do")
    @ResponseBody
    public ServerResponse<PageInfo<SalesVo>> sales(String start, String end, String pageNum, String pageSize) {
	    	Date startDate = null;
	    	Date endDate = null;
    		if(StringUtils.isNotEmpty(start))
    			startDate = DateUtils.parseDateRemoteDetails(start);
    		if(StringUtils.isNotEmpty(end))
    			endDate = DateUtils.parseDateRemoteDetails(end);
    		return iBookingService.querySales(startDate, endDate, Integer.valueOf(pageNum), Integer.valueOf(pageSize));
    }
    
    @RequestMapping(value = "itmes.do")
    @ResponseBody
    public ServerResponse<PageInfo<BookingItem>> queryBookingItems(String start, String end, Integer pageNum, Integer pageSize) {
    	Date startDate = null;
    	Date endDate = null;
		if(StringUtils.isNotEmpty(start))
			startDate = DateUtils.parseDateRemoteDetails(start);
		if(StringUtils.isNotEmpty(end))
			endDate = DateUtils.parseDateRemoteDetails(end);
		return iBookingService.queryBookingItems(startDate, endDate, pageNum, pageSize);
    }
    
    @RequestMapping(value = "brief.do")
    @ResponseBody
    public ServerResponse<PageInfo<BookingBriefVo>> queryBookingBrief(String start, String end, Integer status, Integer pageNum, Integer pageSize) {
    	Date startDate = null;
    	Date endDate = null;
		if(StringUtils.isNotEmpty(start))
			startDate = DateUtils.parseDateRemoteDetails(start);
		if(StringUtils.isNotEmpty(end))
			endDate = DateUtils.parseDateRemoteDetails(end);
		return iBookingService.queryBookingBrief(startDate, endDate, status, pageNum, pageSize);
    }
    
    @RequestMapping(value = "briefStatus.do")
    @ResponseBody
    public ServerResponse<PageInfo<BookingBriefVo>> queryBookingBriefByStatus(Integer status, Integer pageNum, Integer pageSize) {
		return iBookingService.queryBookingBriefByStatus(status, pageNum, pageSize);
    }
}
