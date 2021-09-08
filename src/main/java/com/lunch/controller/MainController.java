package com.lunch.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lunch.service.LunchService;
import com.lunch.vo.MainVO;

@Controller
public class MainController {
	
	@Autowired
	LunchService lunchService ;
	
	MainVO mainvo ;
	
	Map<String, String> lunchMap = new HashMap<>();
	
	
	@GetMapping("/menu")
	@ResponseBody
	public Map<String, String> menu() {
		
		for(int i = 1 ; i < 4 ; i++ ) {
			mainvo = lunchService.selectLunch();
			lunchMap.put(mainvo.menu,mainvo.store);
		}
		
		System.out.println(lunchMap);
		
		return lunchMap;
	}

}
