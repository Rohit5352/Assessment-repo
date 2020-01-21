package com.xebia.assessment.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.xebia.assessment.model.ProductDetail;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<ProductDetail, Long> {

	
	
}
