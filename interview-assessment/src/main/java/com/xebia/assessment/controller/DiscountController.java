package com.xebia.assessment.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xebia.assessment.bizlayer.service.IDiscountBizService;
import com.xebia.assessment.response.JSONResponse;



@RestController
@RequestMapping("/discount")
public class DiscountController {

	@Autowired
	private IDiscountBizService discountBizService;

	@GetMapping("/get/user_id/{user_id}/store_id/{store_id}/product_id/{product_id}")
	public ResponseEntity<?> getDiscount(HttpServletRequest request,
			@PathVariable(value = "user_id", required = true) Long userId,
			@PathVariable(value = "store_id", required = true) Long storeId,
			@PathVariable(value = "product_id", required = true) Long productId,
			@RequestParam(value = "total_bill_amt", required = true) Double totalBillAmt) {

		ResponseEntity<?> responseEntity = null;

		JSONResponse jsonResponse = discountBizService.getDiscount(userId, storeId, productId, totalBillAmt);

		if (jsonResponse != null) {
			if (jsonResponse.getStatus() == HttpStatus.OK.value()) {
				responseEntity = new ResponseEntity<JSONResponse>(jsonResponse, HttpStatus.OK);
			} else if (jsonResponse.getStatus() == HttpStatus.BAD_REQUEST.value()) {
				responseEntity = new ResponseEntity<>(jsonResponse, HttpStatus.BAD_REQUEST);
			} else if (jsonResponse.getStatus() == HttpStatus.NO_CONTENT.value()) {
				responseEntity = new ResponseEntity<>(jsonResponse, HttpStatus.NO_CONTENT);
			} else {
				responseEntity = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

		return responseEntity;
	}

}
