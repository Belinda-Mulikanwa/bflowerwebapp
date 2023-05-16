package com.bflowerApp.bflowerApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bflowerApp.bflowerApp.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
	
	Login findByUsernameAndPassword(String username, String password);
}
