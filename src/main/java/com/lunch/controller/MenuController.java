package com.lunch.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lunch.domain.Alert;
import com.lunch.domain.Menu;
import com.lunch.repository.MenuRepository;
import com.lunch.service.MenuService;
import com.lunch.util.DateUtil;

@Controller
public class MenuController {
	
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	private MenuService menuService;
	
	@Autowired 
	private MenuRepository menuRepo;
	
	@GetMapping("/menu/select")
	private String getMenu(Model model, String nation) {
		
		model.addAttribute("menu", menuService.selectLunch(nation));
		model.addAttribute("date", DateUtil.createDate());

		return "menu/menu";
	}
	
	@GetMapping("/menu/all")
	private String getAllMenu(Model model) {
		
		model.addAttribute("menu", menuService.selectLunch("all"));
		model.addAttribute("date", DateUtil.createDate());

		return "menu/allmenu";
	}
	
	@GetMapping("/menu/add")
	private String addMenu(Model model) {
		
		model.addAttribute("date", DateUtil.createDate());
		
		return "add/addMenu";
	}
	
	@PostMapping("/menu/add/save")
	private String saveMenu(@RequestParam String input, String nation, Model model) {
		
		if(validation(input)) {
			menuService.saveMenu(new Menu(input, nation));
			return "redirect:/menu/add";
		} else {
			model.addAttribute("params", new Alert("이미 존재하는 메뉴입니다.", "/menu/add", input));
			return "common/alert";
		}
	}
	
	private boolean validation(String input) {
		
		boolean check = false;
		
		if(menuRepo.findByMenu(input).isEmpty()) {
			check = true;
		}
		
		return check;
	}
	
}
