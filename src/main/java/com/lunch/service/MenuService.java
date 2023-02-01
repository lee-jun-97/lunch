package com.lunch.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lunch.domain.Menu;
import com.lunch.repository.HistoryRepository;
import com.lunch.repository.MenuRepository;

@Service
public class MenuService {
	
	@Autowired
	private MenuRepository menuRepo;
	
	@Autowired
	private HistoryRepository historyRepo;
	
	
	public List<Menu> selectLunch(String nation) {
		
		List<Menu> list = new ArrayList<Menu>();
		
		if(nation.equals("empty")) {
			list = menuRepo.findAll();
		} else {
			list = menuRepo.findByNation(nation);
		}
		
		Collections.shuffle(list);
		
		List<Menu> result = new ArrayList<Menu>();
		for(int i=0; i<(list.size()>3?3:list.size()); i++) {
			result.add(list.get(i));
		}
		
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
	
}
