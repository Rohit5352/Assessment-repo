package com.xebia.assessment.service;

import java.util.Optional;

import com.xebia.assessment.model.StoreDetail;

public interface IStoreDetailService {

	Optional<StoreDetail> findById(Long id);
	
}
