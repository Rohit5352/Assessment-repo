package com.xebia.assessment.service;

import java.util.Optional;

import com.xebia.assessment.model.UserDetail;

public interface IUserDetailService {

	Optional<UserDetail> findById(Long id);
	
}
