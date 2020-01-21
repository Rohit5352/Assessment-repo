package com.xebia.assessment.bizlayer.service;

import com.xebia.assessment.response.JSONResponse;

public interface IDiscountBizService {

	JSONResponse getDiscount(Long userId, Long storeId, Long productId, Double totalAmt);
	
}
