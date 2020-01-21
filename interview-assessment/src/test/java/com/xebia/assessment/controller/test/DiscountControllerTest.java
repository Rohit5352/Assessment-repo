package com.xebia.assessment.controller.test;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.xebia.assessment.bizlayer.service.IDiscountBizService;
import com.xebia.assessment.controller.DiscountController;
import com.xebia.assessment.response.JSONResponse;


@RunWith(MockitoJUnitRunner.class)
public class DiscountControllerTest {

	@InjectMocks
	private DiscountController discountController;

	@Mock
	private HttpServletRequest request;
	
	@Mock
	private IDiscountBizService discountBizService;
	
	@Mock
	ResponseEntity<?> responseEntity;
	
	@Before
	public void before() {

	}

	@Test
	public void getDiscountTest() {
		
		Long userId = 1l;
		Long storeId = 1l;
		Long productId = 1l;
		Double totalBillAmt = 345.0d;
		
		//responseEntity = new ResponseEntity(jsonResponse, HttpStatus.OK);
		
		JSONResponse jsonResponse = new JSONResponse();
		
		jsonResponse.setStatus(HttpStatus.OK.value());
		
		Mockito.when(discountBizService.getDiscount(userId, storeId, productId, totalBillAmt))
		.thenReturn(jsonResponse);
		
		discountController.getDiscount(request, userId, storeId, productId, totalBillAmt);
		
		
		jsonResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		
		Mockito.when(discountBizService.getDiscount(userId, storeId, productId, totalBillAmt))
		.thenReturn(jsonResponse);
		
		discountController.getDiscount(request, userId, storeId, productId, totalBillAmt);
		
		jsonResponse.setStatus(HttpStatus.NO_CONTENT.value());
		
		Mockito.when(discountBizService.getDiscount(userId, storeId, productId, totalBillAmt))
		.thenReturn(jsonResponse);
		
		discountController.getDiscount(request, userId, storeId, productId, totalBillAmt);
		
		jsonResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		Mockito.when(discountBizService.getDiscount(userId, storeId, productId, totalBillAmt))
		.thenReturn(jsonResponse);
		
		discountController.getDiscount(request, userId, storeId, productId, totalBillAmt);
		
				
		Mockito.when(discountBizService.getDiscount(userId, storeId, productId, totalBillAmt))
		.thenReturn(null);
				
		discountController.getDiscount(request, userId, storeId, productId, totalBillAmt);
		
		
	}

}
