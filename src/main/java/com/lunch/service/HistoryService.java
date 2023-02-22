package com.lunch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lunch.domain.LunchHistory;
import com.lunch.domain.Menu;
import com.lunch.repository.LunchHistoryRepository;
import com.lunch.repository.MailHistoryRepository;
import com.lunch.util.DateUtil;

@Service
public class HistoryService {
	
	private LunchHistoryRepository lunchHistoryRepo;
	private MailHistoryRepository mailHistoryRepo;
	private DateUtil dateUtil;
	
	public HistoryService(LunchHistoryRepository lunchHistoryRepo, MailHistoryRepository mailHistoryRepo, DateUtil dateUtil) {
		this.lunchHistoryRepo = lunchHistoryRepo;
		this.mailHistoryRepo = mailHistoryRepo;
		this.dateUtil = dateUtil;
	}
	
//	@Autowired
//	private LunchHistoryRepository lunchHistoryRepo;
//	@Autowired
//	private MailHistoryRepository mailHistoryRepo;
//	@Autowired
//	private DateUtil dateUtil;
	
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
	
	public void mailHistoryInsert() {
		
	}

}
