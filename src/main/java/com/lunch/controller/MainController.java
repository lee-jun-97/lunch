package com.lunch.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lunch.util.DateUtil;
import com.lunch.vo.Menu;

@Controller
public class MainController {
	
	@Autowired
	private DateUtil dateUtil;

	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/subscribe")
	public String subscribe(Model model) {
		model.addAttribute("date", dateUtil.createDate());
		return "subscribe/subscribe";
	}
	
	@GetMapping("/menu")
	private String menu(Model model) {
		model.addAttribute("menu", new ArrayList<Menu>());
		model.addAttribute("date", dateUtil.createDate());
		return "menu/menu";
	}
	
	
	@GetMapping("/subscribe/cancel")
	public String subscribeCancel() {
		return "subscribe/subscribeCancel";
	}

}