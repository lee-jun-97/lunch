package com.lunch.service;

import java.util.List;

import com.lunch.vo.Menu;
import com.lunch.vo.User;

public interface HistoryService {
	
	public void lunchHistoryInsert(List<Menu> list);
	public void mailHistoryInsert(List<User> userList, List<Menu> menuList);

}
