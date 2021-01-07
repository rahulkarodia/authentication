package com.assessment.userauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.assessment.userauth.model.User;


public interface UserRepository extends  JpaRepository<User, Integer> {
	User findByUsername(String username);
}