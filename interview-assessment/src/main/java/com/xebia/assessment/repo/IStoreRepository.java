package com.xebia.assessment.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.xebia.assessment.model.StoreDetail;



@Repository
public interface IStoreRepository extends PagingAndSortingRepository<StoreDetail, Long> {

	
	
}
