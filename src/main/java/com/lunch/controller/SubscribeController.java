package com.lunch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.lunch.service.SubscribeService;
import com.lunch.util.DateUtil;
import com.lunch.vo.Alert;
import com.lunch.vo.User;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class SubscribeController {
	
	private SubscribeService subscribeService;
	private DateUtil dateUtil;
	
	@PostMapping("/subscribe/add")
	public String subscribeAdd(String email, String name, Model model) {
		if(subscribeService.isRegist(email)) {
			model.addAttribute("params", new Alert("이미 등록된 이메일 입니다.", "/subscribe", null));
		} else if(subscribeService.isRegist(name)) {
			model.addAttribute("params", new Alert("다른 이메일이 이미 등록 되어있습니다.", "/subscribe", null));
		} else {
			if(subscribeService.isExist(email, name)) {
				subscribeService.updateUser(email, dateUtil.createDatetime(), null, "Y");
			} else {
				subscribeService.userAdd(new User(email, name, dateUtil.createDatetime(), "Y"));
			}
			model.addAttribute("params", new Alert("구독 신청 되었습니다.", "/subscribe", null));
		}
		return "common/alert";
	}
	
	@PostMapping("/subscribe/cancel/save")
	public String subscribeCancel(Model model, String email) {
		
		if(!subscribeService.isRegist(email)) {
			model.addAttribute("params", new Alert("구독 신청이 되어 있지 않습니다.", "/subscribe/cancel", null));
		} else {
			subscribeService.updateUser(email, dateUtil.createDatetime(), "N");
			model.addAttribute("params", new Alert("구독 취소 되었습니다.", "/", null));
		}
		
		return "common/alert";
	}

}
