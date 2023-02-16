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
	
	public boolean findByEmail(String email) {
		if(userRepo.findByEmail(email) == null) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean findByName(String name) {
		if(userRepo.findByName(name) == null) {
			return false;
		} else {
			return true;
		}
	}
}
