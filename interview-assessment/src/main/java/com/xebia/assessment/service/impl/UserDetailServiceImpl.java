package com.xebia.assessment.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.assessment.model.UserDetail;
import com.xebia.assessment.repo.IUserRepository;
import com.xebia.assessment.service.IUserDetailService;



@Service
public class UserDetailServiceImpl implements IUserDetailService {

	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public Optional<UserDetail> findById(Long id) {
		return userRepository.findById(id);
	}

}
