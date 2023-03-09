package com.lunch.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lunch.repository.MenuRepository;
import com.lunch.vo.Menu;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MenuServiceImpl implements MenuService{

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
			
			if(isListSizeZero(list)) {
				return new ArrayList<Menu>();
			}
			
			result = addResult(list, list.size());			
		} else {
			list = menuRepo.findByNation(nation);
			
			if(isListSizeZero(list)) {
				return new ArrayList<Menu>();
			}
			
			result = addResult(list, 3);
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
	
	public boolean isListSizeZero(List<Menu> list) {
		if(list.size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public List<Menu> addResult(List<Menu> list, int n) {
		
		List<Menu> temp = new ArrayList<Menu>();
		
		Collections.shuffle(list);
		
		int cnt = 0;
		
		if(n == 3) {
			cnt = list.size() < 3?list.size():3;
		} else {
			cnt = list.size();
		}
		
		for(int i=0; i<cnt; i++) {
			temp.add(list.get(i));
		}
		
		return temp;
	}
	
}
