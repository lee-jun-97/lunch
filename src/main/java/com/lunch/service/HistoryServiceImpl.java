package com.lunch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lunch.repository.LunchHistoryRepository;
import com.lunch.repository.MailHistoryRepository;
import com.lunch.util.DateUtil;
import com.lunch.vo.LunchHistory;
import com.lunch.vo.MailHistory;
import com.lunch.vo.Menu;
import com.lunch.vo.User;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HistoryServiceImpl implements HistoryService {
	
	private LunchHistoryRepository lunchHistoryRepo;
	private MailHistoryRepository mailHistoryRepo;
	private DateUtil dateUtil;
	
	public void lunchHistoryInsert(List<Menu> list) {
		
		LunchHistory lunchHistory = new LunchHistory();
		
		int size = list.size();
		
		if(size >= 1) {
			lunchHistory.setFirst_menu(list.get(0).menu);
		}
		
		if(size >= 2) {
			lunchHistory.setSecond_menu(list.get(1).menu);
		}
		
		if(size == 3) {
			lunchHistory.setThird_menu(list.get(2).menu);
		}
		
		lunchHistory.setSelect_date(dateUtil.createDatetime());
		
		lunchHistoryRepo.save(lunchHistory);
		
	}
	
	public void mailHistoryInsert(List<User> userList, List<Menu> menuList) {
		
		for(User i : userList) {
			MailHistory mail = new MailHistory();
			
			mail.setEmail(i.email);
			mail.setName(i.name);
			
			if(menuList.size() >= 1) {
				mail.setFirst_menu(menuList.get(0).menu);
			}
			
			if(menuList.size() >= 2) {
				mail.setSecond_menu(menuList.get(1).menu);
			}
			
			if(menuList.size() == 3) {
				mail.setThird_menu(menuList.get(2).menu);
			}
			
			mail.setSend_date(dateUtil.createDatetime());
			
			mailHistoryRepo.save(mail);
			
		}
		
	}

}
