package com.bflowerApp.bflowerApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bflowerApp.bflowerApp.entity.Login;
import com.bflowerApp.bflowerApp.repository.LoginRepository;

@Service 
public class LoginService {

	@Autowired 
	private LoginRepository repo;
	
	public Login login(String username, String password) {
		Login user = repo.findByUsernameAndPassword(username, password);
		return user;
	}
}
