package com.xebia.assessment.bizlayer.service.impl.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import com.xebia.assessment.bizlayer.service.impl.DiscountBizServiceImpl;
import com.xebia.assessment.enums.ProductCategory;
import com.xebia.assessment.enums.RoleType;
import com.xebia.assessment.model.ProductDetail;
import com.xebia.assessment.model.RoleDetail;
import com.xebia.assessment.model.StoreDetail;
import com.xebia.assessment.model.UserDetail;
import com.xebia.assessment.service.IProductDetailService;
import com.xebia.assessment.service.IUserDetailService;

@RunWith(MockitoJUnitRunner.class)
public class DiscountBizServiceImplTest {

	@InjectMocks
	private DiscountBizServiceImpl discountBizServiceImpl;
	
	@Mock
	private IUserDetailService userDetailService;
	
	@Mock
	private IProductDetailService productDetailService;
	
	@Before
	public void before() {

	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void getDiscountTest() {
		Long userId = 1l;
		Long storeId = 1l;
		Long productId = 1l;
		Double totalBillAmt = 345.0d;
		
		Optional<ProductDetail> prdtDtlsOptional = null;
		ProductDetail productDetail = new ProductDetail();
		
		prdtDtlsOptional = Optional.ofNullable(null);
		Mockito.when(productDetailService.findById(productId)).thenReturn(prdtDtlsOptional);
		discountBizServiceImpl.getDiscount(userId, storeId, productId, totalBillAmt);
		
		productDetail.setCategory(ProductCategory.GROCERY.toString());
		prdtDtlsOptional = Optional.of(productDetail);
		Mockito.when(productDetailService.findById(productId)).thenReturn(prdtDtlsOptional);
		discountBizServiceImpl.getDiscount(userId, storeId, productId, totalBillAmt);
		
		
		Optional<UserDetail> userDetailOptional = null;
		UserDetail userDetail = new UserDetail();
		productDetail.setCategory(ProductCategory.FASHION.toString());
		userDetail.setId(1l);
		userDetail.setCreatedDate(getCreatedDate("2016-12-18 10:43:35"));
		
		Set<StoreDetail> stores = new HashSet<StoreDetail>();
		
		StoreDetail store = new StoreDetail();
		store.setId(1l);
		stores.add(store);
		userDetail.setStores(stores);
		
		userDetailOptional = Optional.ofNullable(null);
		
		prdtDtlsOptional = Optional.of(productDetail);
		Mockito.when(userDetailService.findById(productId)).thenReturn(userDetailOptional);
		discountBizServiceImpl.getDiscount(userId, storeId, productId, totalBillAmt);
		
		RoleDetail roleDetail = new RoleDetail();
		roleDetail.setName(RoleType.AFFILIATE_USER.toString());
		userDetail.setRole(roleDetail);
		
		userDetailOptional = Optional.of(userDetail);
		Mockito.when(userDetailService.findById(productId)).thenReturn(userDetailOptional);
		discountBizServiceImpl.getDiscount(userId, storeId, productId, totalBillAmt);
		
		roleDetail.setName(RoleType.EMPLOYEE.toString());
		userDetail.setRole(roleDetail);
		Mockito.when(userDetailService.findById(productId)).thenReturn(userDetailOptional);
		discountBizServiceImpl.getDiscount(userId, storeId, productId, totalBillAmt);
		
		roleDetail.setName(RoleType.CUSTOMER.toString());
		userDetail.setRole(roleDetail);
		Mockito.when(userDetailService.findById(productId)).thenReturn(userDetailOptional);
		discountBizServiceImpl.getDiscount(userId, storeId, productId, totalBillAmt);
		
		roleDetail.setName("test-role");
		userDetail.setRole(roleDetail);
		Mockito.when(userDetailService.findById(productId)).thenReturn(userDetailOptional);
		discountBizServiceImpl.getDiscount(userId, storeId, productId, totalBillAmt);
		
		stores = new HashSet<StoreDetail>();
		store.setId(2l);
		stores.add(store);
		userDetail.setStores(stores);
		
		userDetailOptional = Optional.of(userDetail);
		Mockito.when(userDetailService.findById(productId)).thenReturn(userDetailOptional);
		discountBizServiceImpl.getDiscount(userId, storeId, productId, totalBillAmt);
		
		
		stores = new HashSet<StoreDetail>();
		store.setId(1l);
		stores.add(store);
		userDetail.setStores(stores);
		
		roleDetail.setName(RoleType.CUSTOMER.toString());
		userDetail.setCreatedDate(getCreatedDate("2018-12-18 10:43:35"));
		userDetailOptional = Optional.of(userDetail);
		Mockito.when(userDetailService.findById(productId)).thenReturn(userDetailOptional);
		discountBizServiceImpl.getDiscount(userId, storeId, productId, totalBillAmt);
		
	}
	
	private Date getCreatedDate(String dateInString) {
		Date date = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        try {

            date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
	}
	
}
