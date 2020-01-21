package com.xebia.assessment.service;

import java.util.Optional;

import com.xebia.assessment.model.RoleDetail;

public interface IRoleDetailService {

	Optional<RoleDetail> findById(Long id);
	
}
