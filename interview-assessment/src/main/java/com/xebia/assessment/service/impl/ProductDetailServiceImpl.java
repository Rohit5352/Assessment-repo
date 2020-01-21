package com.xebia.assessment.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.assessment.model.ProductDetail;
import com.xebia.assessment.repo.IProductRepository;
import com.xebia.assessment.service.IProductDetailService;



@Service
public class ProductDetailServiceImpl implements IProductDetailService {

	@Autowired
	private IProductRepository productRepository;
	
	@Override
	public Optional<ProductDetail> findById(Long id) {
		return productRepository.findById(id);
	}

	
}
