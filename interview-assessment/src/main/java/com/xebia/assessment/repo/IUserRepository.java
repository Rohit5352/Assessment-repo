package com.xebia.assessment.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.xebia.assessment.model.UserDetail;


@Repository
public interface IUserRepository extends PagingAndSortingRepository<UserDetail, Long> {

}
