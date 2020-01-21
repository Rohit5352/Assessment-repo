package com.xebia.assessment.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.xebia.assessment.model.RoleDetail;

@Repository
public interface IRoleRepository extends PagingAndSortingRepository<RoleDetail, Long> {

	
	
}
