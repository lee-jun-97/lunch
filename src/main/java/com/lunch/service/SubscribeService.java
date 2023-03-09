package com.lunch.service;

import com.lunch.vo.User;

public interface SubscribeService {
	
	public void userAdd(User user);
	public boolean isExist(String email, String name);
	public void updateUser(String email, String dead_date, String use_YN);
	public void updateUser(String email, String join_date, String dead_date, String use_YN);
	public boolean isRegist(String str);
}
