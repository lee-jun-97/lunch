package com.lunch.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lunch.domain.Menu;
import com.lunch.repository.MenuRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MenuService {

	private MenuRepository menuRepo;
	private HistoryService historyService;
	
	public List<Menu> selectLunch(String nation) {
		
		if(nation == null) {
			return new ArrayList<Menu>();
		}
		
		List<Menu> list = new ArrayList<Menu>();
		List<Menu> result = new ArrayList<Menu>();

		if(nation.equals("all")) {
			list = menuRepo.findAll();
		} else {
			list = menuRepo.findByNation(nation);
		}
		
		if(list.size() == 0) {
			return new ArrayList<Menu>();
		}
		
		Collections.shuffle(list);
		
		for(int i=0; i<(list.size()>3?3:list.size()); i++) {
			result.add(list.get(i));
		}
		
		historyService.lunchHistoryInsert(result);
		
		return result;
	}
	
	public List<Menu> selectLunch() {
			 
		List<Menu> list = menuRepo.findAll();
		
		Collections.shuffle(list);
		
		List<Menu> result = new ArrayList<Menu>();
		for(int i=0; i<3; i++) {
			result.add(list.get(i));
		}
		
		
		return result;
	}

	
	public void saveMenu(Menu menu) {
		menuRepo.save(menu);
	}
	
	public boolean validation(String input) {
		
		boolean check = false;
		
		if(menuRepo.findByMenu(input).isEmpty()) {
			check = true;
		}
		
		return check;
	}
	
}
