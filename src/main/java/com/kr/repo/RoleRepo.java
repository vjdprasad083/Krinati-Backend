package com.kr.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kr.entities.Roles;
@Repository
public interface RoleRepo extends JpaRepository<Roles,Integer> {

}
