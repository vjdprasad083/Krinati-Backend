package com.kr.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kr.entities.Roles;

public interface RoleRepo extends JpaRepository<Roles,Integer> {

}
