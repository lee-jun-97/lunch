package com.lunch.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lunch.domain.History;
import com.lunch.domain.Menu;
import com.lunch.service.LunchService;

@Controller
public class LunchController {
	
	private static final Logger logger = LoggerFactory.getLogger(LunchController.class);
	
	LunchService lunchService;
	
	public LunchController(LunchService lunchService) {
		this.lunchService = lunchService;
	}
	
	@GetMapping("/menu")
	public String getMenu(Model model) {
		
		List<History> lunchList = new ArrayList<> ();
		
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		lunchList = lunchService.selectLunch(df.format(date));
		
		model.addAttribute("menu", lunchList);
		model.addAttribute("date", df.format(date));

		return "/menu";
	}
	
	@GetMapping("/menu/add")
	public String addMenu(Model model) {
		
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		model.addAttribute("date", df.format(date));
		
		return "addMenu";
	}
	
	@PostMapping("/menu/add/save")
	public String saveMenu(@RequestParam String menu) {
		lunchService.saveMenu(new Menu(menu));
		return "/";
	}
	
	@RequestMapping("/history")
	public String history(Model model) {
		
		model.addAttribute("history", lunchService.historySelect());
		
		return "/history";
	}

}
