package com.xebia.assessment.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.assessment.model.StoreDetail;
import com.xebia.assessment.repo.IStoreRepository;
import com.xebia.assessment.service.IStoreDetailService;


@Service
public class StoreDetailServiceImpl implements IStoreDetailService {

	@Autowired
	private IStoreRepository storeRepository;
	
	@Override
	public Optional<StoreDetail> findById(Long id) {
		return storeRepository.findById(id);
	}

}
