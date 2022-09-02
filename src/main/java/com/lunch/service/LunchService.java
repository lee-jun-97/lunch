package com.lunch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lunch.domain.History;
import com.lunch.domain.Menu;
import com.lunch.repository.HistoryRepository;
import com.lunch.repository.MenuRepository;

@Service
public class LunchService {
	
	@Autowired
	private HistoryRepository historyRepo;
	
	@Autowired
	private MenuRepository menuRepo;
	
//	private static final Logger log = LoggerFactory.getLogger(LunchService.class);
	
	public List<History> selectLunch(String df) {

		List<History> lunchList = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			History mainvo = new History();
			
			mainvo.setDate(df);

			mainvo.setNum(i+1);
			
			if(mainvo.num == 1) {
				mainvo.setDep("메인");
			} else {
				mainvo.setDep("후보");
			}
			
		}
		
		for(History i : lunchList) {
			// DB History Insert
			this.historyInsert(i);
		}
		
		return lunchList;
	}
	
	public void historyInsert(History mainvo) {
		historyRepo.save(mainvo);
	}
	
	public List<History> historySelect() {
		return historyRepo.findAll();
	}
	
	public void saveMenu(Menu menu) {
		menuRepo.save(menu);
	}

}
