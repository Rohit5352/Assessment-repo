package com.xebia.assessment.service;

import java.util.Optional;

import com.xebia.assessment.model.ProductDetail;

public interface IProductDetailService {

	Optional<ProductDetail> findById(Long id);
	
}
