package com.lunch.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lunch.domain.Menu;
import com.lunch.repository.HistoryRepository;
import com.lunch.repository.MenuRepository;
import com.lunch.util.DateUtil;

@Service
public class MenuService {
	
	@Autowired
	private MenuRepository menuRepo;
	
	@Autowired
	private HistoryRepository historyRepo;
	
	
	public List<Menu> selectLunch() {
		
		List<Menu> list = menuRepo.findAll();
		
		Collections.shuffle(list);
		
		List<Menu> result = new ArrayList<Menu>();
		for(int i=0; i<3; i++) {
			result.add(list.get(i));
		}
		
		saveHistory(result, DateUtil.createDate());
		
		return result;
	}

	
	public void saveMenu(Menu menu) {
		menuRepo.save(menu);
	}
	

	
	private void saveHistory(List<Menu> list, String date) {
		historyRepo.saveAll(list, date);
	}
	

}
