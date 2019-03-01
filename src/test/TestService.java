package test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.carlab.common.ServerResponse;
import com.carlab.db.BookingItem;
import com.carlab.db.Customer;
import com.carlab.db.Staff;
import com.carlab.db.UserCarPicture;
import com.carlab.service.IBookingService;
import com.carlab.service.ICustomerService;
import com.carlab.service.IProductCategoryService;
import com.carlab.service.IUserCarService;
import com.carlab.utils.CarlabHelper;
import com.carlab.utils.DateUtil;
import com.carlab.vo.BookingCalenderDate;
import com.carlab.vo.BookingCalenderMonth;
import com.carlab.vo.multiLevelMenu.MutilLevelMenu;
import com.github.pagehelper.PageInfo;

public class TestService {
	private static ApplicationContext ctx; 
    private static IProductCategoryService iProductCategoryService;
    private static IBookingService iBookingService;
    private static IUserCarService iUserCarService;
    private static ICustomerService iCustomerService;
    
	private static void init() {
		ctx = new ClassPathXmlApplicationContext("/conf/spring/applicationContext-main.xml");
		iProductCategoryService = (IProductCategoryService) ctx.getBean("iProductCategoryService");
		iBookingService = (IBookingService) ctx.getBean("iBookingService");
		iUserCarService = (IUserCarService) ctx.getBean("iUserCarService");
		iCustomerService = (ICustomerService) ctx.getBean("iCustomerService");
	}
	
	public static void main(String[] args) {
		try {
			init();
//			testProductCategory();
//			testSaveUserCar();
//			testCustomerCreateBookingItem();
//			testStaffConfirmBookingItem();
//			testCustomerCreateBooking();
//			testStaffConfirmBooking();
//			testSaveCustomer();
//			testPageHelper();
//			testCalenderMonth();
			testDoneBookingItem();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}
	
	public static void testDoneBookingItem() {
		System.out.println(iBookingService.doneBookingItem(null, 2).getMsg());
		System.out.println(iBookingService.doneBookingItem(null, 3).getMsg());
		System.out.println(iBookingService.doneBookingItem(null, 5).getMsg());
	}
	
	public static void testCalenderMonth() {
		Date date = DateUtil.fomatDate("2018-10-01");
		ServerResponse<BookingCalenderMonth> response = iBookingService.queryBookingCalenderByMonth(date);
		BookingCalenderMonth month = response.getData();
		System.out.println("query month: "+month.getMonth());
		System.out.println("size of date: "+month.getBookingCalenderDateMap().size());
		for (Integer key : month.getBookingCalenderDateMap().keySet()) {
			System.out.println("size of item: "+key);
			System.out.println(month.getBookingCalenderDateMap().get(key));
		}
	}
	
	public static void testPageHelper() {
		ServerResponse<PageInfo> response = iCustomerService.selectByPageNumAndPageSize(1, 7);
		PageInfo info = response.getData();
		for (Customer customer : (List<Customer>) info.getList()) {
			System.out.println(customer);
			System.out.println();
		}
		System.out.println(info);
	}
	
	public static void testSaveCustomer() {
		List<Customer> list = new ArrayList<>();
		for (int i = 0; i < 25; i++) {
			Customer customer = new Customer();
			customer.setId("CC_"+i);
			customer.setUsername("username"+i);
			customer.setFullName("wang"+i);
			customer.setGender("F");
			customer.setCreateTime(new Date());
//			list.add(customer);
			System.out.println(customer);
			iCustomerService.save(customer);
		}
		
//		for (Customer customer : list) {
//			System.out.println(customer);
//		}
	}
	
	public static void testStaffConfirmBooking() {
		Staff st = new Staff();
		st.setId("EM_1");
		List<Integer> ids = new ArrayList<>();
		ids.add(2);
		ids.add(5);
		ids.add(6);
		ServerResponse response = iBookingService.confirmBooking(st, 1, ids, 5555);
		System.out.println(response.getMsg());
	}
	
	public static void testStaffConfirmBookingItem() {
		Staff st = new Staff();
		st.setId("EM_1");
		ServerResponse response = iBookingService.confirmBookingItem(st, 2, 1, 1, new BigDecimal("150.50"), "shipping fee", new Date());
		ServerResponse response2 = iBookingService.confirmBookingItem(st, 5, 1, 1, new BigDecimal("150.50"), "shipping fee", new Date());
		ServerResponse response3 = iBookingService.confirmBookingItem(st, 6, 1, 1, new BigDecimal("150.50"), "shipping fee", new Date());
		System.out.println(response.getMsg());
		System.out.println(response2.getMsg());
		System.out.println(response3.getMsg());
	}
	
	public static void testCustomerCreateBooking() {
		Customer c0 = new Customer();
		c0.setId("CC_0");
		List<Integer> ids = new ArrayList<>();
		ids.add(2);
		ids.add(5);
		ids.add(6);
		ServerResponse response = iBookingService.createBooking(c0, "velocity", ids, new Date());
		System.out.println(response.getMsg());
	}
	
	public static void testCustomerCreateBookingItem() {
		Customer c0 = new Customer();
		c0.setId("CC_0");
//		ServerResponse response = iBookingService.createBookingItem(c0, 100011, null,"bmw005", "c0 （第一次递交车信息)");
		
//		Customer c1 = new Customer();
//		c1.setId("CC_1");
//		iBookingService.createBookingItem(c1, 100011, null, "bmw001", "CC_1 提交服务和车信息（第一次递交车信息）");
//		ServerResponse response = iBookingService.createBookingItem(c0, 100011, 4, "update car info", "CC_0 提交服务和车信息（车图片已经存在）");
		ServerResponse response = iBookingService.createBookingItem(c0, 100011, null,"bmw005", "c0 (just for test)");
		System.out.println(response.getMsg());
	}
	
	public static void testSaveUserCar() {
		UserCarPicture userCarPicture = CarlabHelper.assembleUserCarPicture(null, "oldbmw", "newbmw", "bmwpath");
		List<UserCarPicture> list = new ArrayList<>();
		list.add(userCarPicture);
		iUserCarService.saveUserCarAndPicture("CC_1", list);
	}
	
	public static void testProductCategory() {
		MutilLevelMenu menu = iProductCategoryService.findChildCategoryMenu(100001);
		System.out.println(menu);
//		showMenu(menu);
	}
	
	public static void showMenu(MutilLevelMenu menu) {
		System.out.println(menu.getMenuId());
		System.out.println(menu.getMenuName());
		for (MutilLevelMenu subMenu : menu.getSubMenus())
			showMenu(subMenu);
	}
}
