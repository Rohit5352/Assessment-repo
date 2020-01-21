package com.xebia.assessment.service.impl.test;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.xebia.assessment.model.ProductDetail;
import com.xebia.assessment.model.RoleDetail;
import com.xebia.assessment.model.StoreDetail;
import com.xebia.assessment.model.UserDetail;
import com.xebia.assessment.repo.IProductRepository;
import com.xebia.assessment.repo.IRoleRepository;
import com.xebia.assessment.repo.IStoreRepository;
import com.xebia.assessment.repo.IUserRepository;
import com.xebia.assessment.service.impl.ProductDetailServiceImpl;
import com.xebia.assessment.service.impl.RoleDetailServiceImpl;
import com.xebia.assessment.service.impl.StoreDetailServiceImpl;
import com.xebia.assessment.service.impl.UserDetailServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class DiscountAppDaoClassesTest {

	@InjectMocks
	private UserDetailServiceImpl userDataServiceImpl;
	
	@InjectMocks
	private RoleDetailServiceImpl roleDataServiceImpl;
	
	@InjectMocks
	private StoreDetailServiceImpl storeDataServiceImpl;
	
	@InjectMocks
	private ProductDetailServiceImpl productDataServiceImpl;
	
	@Mock
	private IProductRepository productRepository;
	
	@Mock
	private IRoleRepository roleRepository;
	
	@Mock
	private IStoreRepository storeRepository;
	
	@Mock
	private IUserRepository userRepository;
	
	@Test
	public void testDaoClasses() {
		
		Long userId = 1l;
		Long storeId = 1l;
		Long productId = 1l;
		Long roleId = 1l;
		
		Optional<ProductDetail> productOptional = null;
		ProductDetail productDetail = new ProductDetail();
		productOptional = Optional.of(productDetail);
		
		Optional<StoreDetail> storeOptional = null;
		StoreDetail storeDetail = new StoreDetail();
		storeOptional = Optional.of(storeDetail);
		
		Optional<RoleDetail> roleOptional = null;
		RoleDetail roleDetail = new RoleDetail();
		roleOptional = Optional.of(roleDetail);
		
		Optional<UserDetail> userOptional = null;
		UserDetail userDetail = new UserDetail();
		userOptional = Optional.of(userDetail);
		
		Mockito.when(productRepository.findById(productId)).thenReturn(productOptional);
		productDataServiceImpl.findById(productId);
		
		Mockito.when(storeRepository.findById(productId)).thenReturn(storeOptional);
		storeDataServiceImpl.findById(storeId);
		
		Mockito.when(userRepository.findById(productId)).thenReturn(userOptional);
		userDataServiceImpl.findById(userId);
		
		Mockito.when(roleRepository.findById(productId)).thenReturn(roleOptional);
		roleDataServiceImpl.findById(roleId);
				
	}
	
}
