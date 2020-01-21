package com.xebia.assessment.bizlayer.service.impl;

import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.xebia.assessment.bizlayer.DiscountUtility;
import com.xebia.assessment.bizlayer.service.IDiscountBizService;
import com.xebia.assessment.bizlayer.vos.DiscountReponseVO;
import com.xebia.assessment.enums.ProductCategory;
import com.xebia.assessment.enums.RoleType;
import com.xebia.assessment.model.ProductDetail;
import com.xebia.assessment.model.UserDetail;
import com.xebia.assessment.response.JSONResponse;
import com.xebia.assessment.service.IProductDetailService;
import com.xebia.assessment.service.IUserDetailService;



@Service
public class DiscountBizServiceImpl implements IDiscountBizService {
	
	@Autowired
	private IUserDetailService userDetailService;
	
	@Autowired
	private IProductDetailService productDetailService;

	@Override
	public JSONResponse getDiscount(Long userId, Long storeId, Long productId, Double totalAmt) {
		
		JSONResponse jsonResponse  = null;
		
		Optional<ProductDetail> prdtDtlsOptional = productDetailService.findById(productId);
		
		if(prdtDtlsOptional.isPresent()) {
			ProductDetail productDetail = prdtDtlsOptional.get();
			if(productDetail.getCategory().equalsIgnoreCase(ProductCategory.GROCERY.toString())) {
				// Discount is not applicable
				jsonResponse = new JSONResponse(HttpStatus.BAD_REQUEST.value(), "Discount is not applicable for groceries", null);
			} else {
				// Perform discount related operations
				Optional<UserDetail> userDetailOptional = userDetailService.findById(userId);
				
				if(userDetailOptional.isPresent()) {
					UserDetail userDetail = userDetailOptional.get();
					
					boolean isExist = userDetail.getStores().stream().anyMatch(store -> store.getId().equals(storeId));
					
					if(isExist) {
						
						DiscountReponseVO discountReponseVO = new DiscountReponseVO();
						
						Double netPayableAmount = 0.0;
						
						if(userDetail.getRole().getName().equalsIgnoreCase(RoleType.AFFILIATE_USER.toString())) {
							netPayableAmount = DiscountUtility.getDiscount(totalAmt, 10.0);
						} else if(userDetail.getRole().getName().equalsIgnoreCase(RoleType.EMPLOYEE.toString())) {
							netPayableAmount = DiscountUtility.getDiscount(totalAmt, 30.0);
						} else if(userDetail.getRole().getName().equalsIgnoreCase(RoleType.CUSTOMER.toString())) {
							
							Date currentDate = new Date();
							
							long diffInMillies = Math.abs(currentDate.getTime() - userDetail.getCreatedDate().getTime());
						    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
							
						    long months = diff/30;
						    if(months > 24) {
						    	netPayableAmount = DiscountUtility.getDiscount(totalAmt, 5.0);
						    }
							
						}
						discountReponseVO.setTotalAmount(totalAmt);
						discountReponseVO.setNetPayableAmount(netPayableAmount);
						
						if(discountReponseVO.getNetPayableAmount() > 0) {
							jsonResponse = new JSONResponse(HttpStatus.OK.value(),"Data get successfully", discountReponseVO);
						} else {
							jsonResponse = new JSONResponse(HttpStatus.NO_CONTENT.value(),"No discount available", null);
						}
						
						
						
					} else {
						// Thorw exception
						jsonResponse = new JSONResponse(HttpStatus.BAD_REQUEST.value(), "User does not belongs to store", null);
					}
					
				} else {
					// Throw the exception
					jsonResponse = new JSONResponse(HttpStatus.BAD_REQUEST.value(), "User does not exist", null);
				}
			}
			
		} else {
			// Throw the exception
			jsonResponse = new JSONResponse(HttpStatus.BAD_REQUEST.value(), "Product is not available in the store", null);
		}
		
		return jsonResponse;
	}

}
