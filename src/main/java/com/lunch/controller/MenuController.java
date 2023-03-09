package com.lunch.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lunch.service.MenuService;
import com.lunch.util.DateUtil;
import com.lunch.vo.Alert;
import com.lunch.vo.Menu;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MenuController {
	
	private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

	private MenuService menuService;
	private DateUtil dateUtil;
	
	@GetMapping("/menu/select")
	private String getMenu(Model model, String nation) {
		
		if(nation.equals("empty")) {
			model.addAttribute("params", new Alert("해당 음식 종류를 선택하여 주세요.", "/menu", null));
			return "common/alert";
		}
		
		List<Menu> menu = menuService.selectLunch(nation);
		
		if(menu.size() == 0) {
			model.addAttribute("params", new Alert("해당 음식 종류는 저장되어있지 않습니다.", "/menu", null));
			return "common/alert";
		} else {
			model.addAttribute("menu", menu);
			model.addAttribute("date", dateUtil.createDate());
			return "menu/menu";
		}
	}
	
	@GetMapping("/menu/all")
	private String getAllMenu(Model model) {
		
		model.addAttribute("menu", menuService.selectLunch("all"));
		model.addAttribute("date", dateUtil.createDate());

		return "menu/allmenu";
	}
	
	@GetMapping("/menu/add")
	private String addMenu(Model model) {
		
		model.addAttribute("date", dateUtil.createDate());
		
		return "add/addMenu";
	}
	
	@PostMapping("/menu/add/save")
	private String saveMenu(@RequestParam String input, String nation, Model model) {
		
		if(menuService.validation(input)) {
			menuService.saveMenu(new Menu(input, nation));
			return "redirect:/menu/add";
		} else {
			model.addAttribute("params", new Alert("이미 존재하는 메뉴입니다.", "/menu/add", input));
			return "common/alert";
		}
	}
	
}
