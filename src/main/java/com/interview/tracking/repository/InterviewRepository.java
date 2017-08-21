package com.interview.tracking.repository;

import com.interview.tracking.model.Interview;
import com.interview.tracking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by dheeraj on 21/08/17.
 */

@RepositoryRestResource
public interface InterviewRepository extends JpaRepository<Interview, Long>{
}