package com.lunch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lunch.domain.User;
import com.lunch.repository.UserRepository;

@Service
public class SubscribeService {
	
	@Autowired
	private UserRepository userRepo;

	public void userAdd(User user) {
		userRepo.save(user);
	}
	
	public boolean isExist(String email, String name) {
		
		User user = userRepo.findByEmail(email);
		
		if(user == null) {
			return false;
		}
		
		// 존재한다면 취소된 이메일인가 ?
		if(user.use_YN.equals("N")) {
			return true;
		} else 
			return false;
	}
	
	public void updateUser(String email, String dead_date, String use_YN) {
		userRepo.updateUser(email, dead_date, use_YN);
	}
	
	public void updateUser(String email, String join_date, String dead_date, String use_YN) {
		userRepo.updateUser(email, join_date, dead_date, use_YN);
	}
	
	public boolean isRegist(String str) {
		
		User user ;
		
		if(str.contains("@")) {
			user = userRepo.findByEmail(str);
		} else {
			user = userRepo.findByName(str);
		}
		
		if(user != null && user.use_YN.equals("Y")) {
			return true;
		}
		
		return false;
	}
}
