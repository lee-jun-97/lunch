package com.lunch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lunch.util.DateUtil;

@Controller
public class MainController {
	

	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/subscribe")
	public String subscribe(Model model) {
		model.addAttribute("date", DateUtil.createDate());
		return "subscribe/subscribe";
	}
	
	@GetMapping("/menu")
	private String getMenu(Model model) {
		model.addAttribute("date", DateUtil.createDate());
		return "menu/menu";
	}
	
	
	@GetMapping("/subscribe/cancel")
	public String subscribeCancel() {
		return "subscribe/subscribeCancel";
	}

}