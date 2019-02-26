package com.carlab.controller.frontend;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carlab.common.Constants;
import com.carlab.common.ServerResponse;
import com.carlab.controller.base.BaseController;
import com.carlab.db.Booking;
import com.carlab.db.BookingItem;
import com.carlab.db.Customer;
import com.carlab.enums.ResponseCode;
import com.carlab.service.IBookingService;
import com.carlab.utils.CarlabHelper;
import com.carlab.utils.DateUtils;
import com.carlab.utils.StringUtils;

@Controller
@RequestMapping("/booking")
public class BookingController extends BaseController{
//	@Autowired
//    private IUserService iUserService;
    @Autowired
    private IBookingService iBookingService;

    @RequestMapping(value = "item/create.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<BookingItem> createBookingItem(Map<String, String> map) {
    		String categoryStr= map.get("category");
    		String userCarIdStr = map.get("userCarId");
    		String carInfo = map.get("carInfo");
    		String remark = map.get("remark");
    		
    		Integer userCarId = null;
    		if(StringUtils.isEmpty(categoryStr))
    			return ServerResponse.createByErrorMsg("must select a service");
    		if(StringUtils.isNotEmpty(userCarIdStr))
    			userCarId = Integer.getInteger(userCarIdStr);
    		return iBookingService.createBookingItem(getSessionCustomer(), Integer.getInteger(categoryStr), userCarId, carInfo, remark);
    }
    
    @RequestMapping(value = "create.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Booking> createBooking(Map<String, String> map) {
    		String shipping = map.get("shipping");
		String bookingTimeStr = map.get("bookingTime");
		String bookingItemIdStr = map.get("bookingItemIds");
		if(StringUtils.isEmpty(shipping))
			return ServerResponse.createByErrorMsg("location is required");
		if(StringUtils.isEmpty(bookingTimeStr))
			return ServerResponse.createByErrorMsg("booking time is required");
		if(StringUtils.isEmpty(bookingItemIdStr))
			return ServerResponse.createByErrorMsg("must select at least one service");
		List<Integer> bookingItemIds = CarlabHelper.string2Integerlist(bookingItemIdStr);
		Date bookingTime = DateUtils.parseDateForStandard(bookingTimeStr);
		return iBookingService.createBooking(getSessionCustomer(), shipping, bookingItemIds, bookingTime);
    }
    
    
}
