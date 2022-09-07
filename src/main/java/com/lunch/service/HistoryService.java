package com.lunch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lunch.domain.History;
import com.lunch.domain.Menu;
import com.lunch.repository.HistoryRepository;

@Service
public class HistoryService {
	
	@Autowired
	private HistoryRepository historyRepo;
	
	public void historyInsert(List<Menu> menu, String date) {
		
		List<History> list = new ArrayList<>();
		
		for(Menu i : menu) {
			History history = new History();
			
			history.setMenu(i.getMenu());
			history.setDate(date);

			list.add(history);
		}
		
		historyRepo.saveAll(list);
	}

}