package com.carlab.controller.base;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.carlab.common.Constants;
import com.carlab.db.Customer;
import com.carlab.db.Staff;



public class BaseController {
	
	protected Logger logger = Logger.getLogger(this.getClass());

	private static final long serialVersionUID = 6357869213649815390L;
	
	public Customer getSessionCustomer() {
		Object o = getSession().getAttribute(Constants.CUSTOMER_SESSION);
		if(o == null)
			return null;
		else 
			return (Customer) o;
	}
	
	public Staff getSessionStaff() {
		Object o = getSession().getAttribute(Constants.STAFF_SESSION);
		if(o == null)
			return null;
		else 
			return (Staff) o;
	}
	
	public HttpServletRequest getRequest() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	public HttpServletResponse getResponse() {
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
	}
	
	public void responseWriter(String content) {
		try {
			getResponse().setContentType("text/plain;charset=utf-8");
			PrintWriter writer = getResponse().getWriter();
			writer.write(content);
			writer.flush();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public HttpSession getSession() {
		return getRequest().getSession();
	}
	
}
