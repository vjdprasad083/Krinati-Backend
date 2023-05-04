package com.kr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kr.entities.JobExperience;

@Repository
public interface JobExperienceRepo extends JpaRepository<JobExperience,Integer> {
	
}
