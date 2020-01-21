package com.xebia.assessment.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.assessment.model.RoleDetail;
import com.xebia.assessment.repo.IRoleRepository;
import com.xebia.assessment.service.IRoleDetailService;


@Service
public class RoleDetailServiceImpl implements IRoleDetailService {

	@Autowired
	private IRoleRepository roleRepository;
	
	@Override
	public Optional<RoleDetail> findById(Long id) {
		return roleRepository.findById(id);
	}

}
