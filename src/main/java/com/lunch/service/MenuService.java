package com.lunch.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lunch.domain.Menu;
import com.lunch.repository.MenuRepository;

@Service
public class MenuService {
	
	@Autowired
	private MenuRepository menuRepo;
	
//	private static final Logger log = LoggerFactory.getLogger(LunchService.class);
	
	public List<Menu> selectLunch() {
		
		List<Menu> list = menuRepo.findAll();
		
		Collections.shuffle(list);
		
		List<Menu> result = new ArrayList<>();
		for(int i=0; i<3; i++) {
			result.add(list.get(i));
		}
		
		return result;
	}

	
	public void saveMenu(Menu menu) {
		menuRepo.save(menu);
	}
	
	public boolean validation(String input) {
		
		boolean check;
		
		if(menuRepo.findByMenu(input).isEmpty()) {
			check = true;
		} else {
			check = false;
		}
		
		return check;
	}

}
