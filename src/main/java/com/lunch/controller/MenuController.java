package com.lunch.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lunch.domain.Menu;
import com.lunch.service.HistoryService;
import com.lunch.service.LunchService;

@Controller
public class MenuController {
	
//	private static final Logger logger = LoggerFactory.getLogger(LunchController.class);
	
	@Autowired
	private LunchService lunchService;
	@Autowired
	private HistoryService historyService;
	@Autowired
	private Menu menu;
	
	@GetMapping("/menu")
	public String getMenu(Model model) {
		
		List<Menu> lunchList = new ArrayList<> ();

		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		lunchList = lunchService.selectLunch();
		
		historyService.historyInsert(lunchList, df.format(date));
		
		model.addAttribute("menu", lunchList);
		model.addAttribute("date", df.format(date));

		return "menu";
	}
	
	@GetMapping("/menu/add")
	public String addMenu(Model model) {
		
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		model.addAttribute("date", df.format(date));
		
		return "addMenu";
	}
	
	@PostMapping("/menu/add/save")
	public String saveMenu(@RequestParam String input) {
		menu.setMenu(input);
		if(lunchService.validation(input)) {
			lunchService.saveMenu(this.menu);
			return "redirect:/";
		} else {
			return "redirect:/menu/add";
		}
	}
	
}