package com.lunch.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.lunch.domain.Alert;
import com.lunch.domain.User;
import com.lunch.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/user")
	public String user(Model model) {
		
		Date date = new Date();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		model.addAttribute("date", df.format(date));
		
		return "addUser";
	}
	
	@PostMapping("/user/add")
	public String userAdd(String email, String name, Model model) {
		
		
		Date date = new Date();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		userService.userAdd(new User(email, name, df.format(date), "Y"));
		
		model.addAttribute("params", new Alert("저장되었습니다.", "/user", null));
		
		return "common/alert";
	}

}
