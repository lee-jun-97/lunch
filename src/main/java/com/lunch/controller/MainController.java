package com.lunch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
//	private static final Logger log = LoggerFactory.getLogger(MainController.class);

	@GetMapping("/")
	public String home() {
		return "/home";
	}

	

}