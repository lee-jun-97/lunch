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

import com.lunch.domain.Alert;
import com.lunch.domain.Menu;
import com.lunch.service.HistoryService;
import com.lunch.service.MenuService;

@Controller
public class MenuController {
	
//	private static final Logger logger = LoggerFactory.getLogger(LunchController.class);
	
	@Autowired
	private MenuService menuService;
	@Autowired
	private HistoryService historyService;
	
	@GetMapping("/menu")
	public String getMenu(Model model) {
		
		List<Menu> lunchList = new ArrayList<Menu>();

		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		lunchList = menuService.selectLunch();
		
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
	public String saveMenu(@RequestParam String input, Model model) {
		
		if(menuService.validation(input)) {
			menuService.saveMenu(new Menu(input));
			return "redirect:/menu/add";
		} else {
			model.addAttribute("params", new Alert("이미 존재하는 메뉴입니다.", "/menu/add", input));
			return "common/alert";
		}
	}
	
}
