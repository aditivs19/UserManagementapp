package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.UserDtls;
@Service
public interface UserService {
	
	public UserDtls createUser(UserDtls user);
	
	public boolean checkEmail(String email);

}
