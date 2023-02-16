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
import com.lunch.service.SubscribeService;
import com.lunch.util.DateUtil;

@Controller
public class SubscribeController {
	
	@Autowired
	private SubscribeService subscribeService;
	
	@GetMapping("/subscribe")
	public String user(Model model) {
		model.addAttribute("date", DateUtil.createDate());
		return "subscribe/subscribe";
	}
	
	@PostMapping("/subscribe/add")
	public String userAdd(String email, String name, Model model) {
		
		
		Date date = new Date();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		if(isRegistEmail(email)) {
			model.addAttribute("params", new Alert("이미 등록된 이메일 입니다.", "/subscribe", null));
			return "common/alert";
		}
		
		if(isRegistName(name)) {
			model.addAttribute("params", new Alert("같은 이름으로 등록된 다른 이메일이 있습니다.", "/subscribe", null));
			return "common/alert";
		}
		
		subscribeService.userAdd(new User(email, name, df.format(date), "Y"));
		model.addAttribute("params", new Alert("저장되었습니다.", "/user", null));
		
		return "common/alert";
	}
	
	public boolean isRegistEmail(String email) {
		if(subscribeService.findByEmail(email)) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean isRegistName(String name) {
		if(subscribeService.findByName(name)) {
			return false;
		} else {
			return true;
		}
	}

}
