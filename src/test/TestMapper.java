package test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.carlab.db.BookingItem;
import com.carlab.db.Merchant;
import com.carlab.db.Product;
import com.carlab.db.Staff;
import com.carlab.db.vo.SalesVo;
import com.carlab.mapper.BookingItemMapper;
import com.carlab.mapper.CustomerMapper;
import com.carlab.mapper.MerchantMapper;
import com.carlab.mapper.ProductMapper;
import com.carlab.mapper.StaffMapper;
import com.carlab.utils.DateUtil;
import com.carlab.utils.DateUtils;

public class TestMapper {
	private static ApplicationContext ctx; 
	private static BookingItemMapper bookingItemMapper;
	private static ProductMapper productMapper;
	private static CustomerMapper customerMapper;
	private static MerchantMapper merchantMapper;
	private static StaffMapper staffMapper;
    
	private static void init() {
		ctx = new ClassPathXmlApplicationContext("/conf/spring/applicationContext-main.xml");
		bookingItemMapper = (BookingItemMapper) ctx.getBean("bookingItemMapper");
		productMapper = (ProductMapper) ctx.getBean("productMapper");
		customerMapper = (CustomerMapper) ctx.getBean("customerMapper");
		merchantMapper = (MerchantMapper) ctx.getBean("merchantMapper");
		staffMapper = (StaffMapper) ctx.getBean("staffMapper");
	}
	
	public static void main(String[] args) {
		try {
			init();
//			testSelectProductByIds();
//			testSelectBookingItemByIds(); 
//			testSelectByDate();
//			testSelectCustomer();
//			testSelectSales();
//			testAddMerchant();
//			testAddStaff();
//			testMerchantQuickLook();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}
	
	public static void testMerchantQuickLook() {
		System.out.println(merchantMapper.quickLookList());
	}
	
	public static void testAddStaff() {
		Staff staff = new Staff("EM_0", "em0", "123", "emm", "com", "leader", new Date(), new Date(), 0);
		System.out.println(staffMapper.insert(staff));
	}
	
	public static void testSelectSales() {
		Date start = DateUtil.fomatDate("2019-02-01 00:00:00");
		Date end = DateUtil.fomatDate("2019-03-01 00:00:00");
		List<SalesVo> sales = bookingItemMapper.selectSalesSummarized(start, end);
		for (SalesVo salesVo : sales) {
			System.out.println(salesVo);
		}
	}
	
	public static void testAddMerchant() {
		Merchant merchant = new Merchant("CM_1", "merchant1", "123123", "abd", "F", "00001", "dimdesign1", "12345568", "com", "mer", "123", "", 0.3, "http", new Date(), new Date(), 0);
		System.out.println(merchantMapper.insert(merchant));
		System.out.println(merchantMapper.selectByPrimaryKey("CM_0"));
	}
	
	public static void testSelectByDate() {
//		Timestamp start = DateUtils.convertTimestamp(DateUtil.fomatDate("2018-10-03 00:00:00"));
//		Timestamp end = DateUtils.convertTimestamp(DateUtil.fomatDate("2018-10-04 00:00:00"));
		Date start = DateUtil.fomatDate("2018-10-03 00:00:00");
		Date end = DateUtil.fomatDate("2018-10-04 00:00:00");
		List<BookingItem> items = bookingItemMapper.selectByDate(start, end);
		System.out.println(items);
	}
	
	public static void testSelectCustomer() {
		System.out.println(customerMapper.selectByKeyAndPass("CC_0", "0"));
	}
	
	public static void testSelectBookingItemByIds() {
		List<Integer> ids = new ArrayList<>();
		ids.add(2);
		ids.add(3);
		ids.add(4);
		ids.add(5);
		ids.add(6);
		List<BookingItem> items = bookingItemMapper.selectByPrimaryKeys(ids);
		System.out.println(items);
	}
	
	public static void testSelectProductByIds() {
		List<Integer> ids = new ArrayList<>();
		ids.add(2);
		ids.add(3);
		ids.add(4);
		List<Product> products = productMapper.selectProductByIds(ids);
		System.out.println(products);
	}
}
