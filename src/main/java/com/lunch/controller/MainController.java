package com.lunch.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lunch.service.LunchService;
import com.lunch.vo.MainVO;

@Controller
public class MainController {
	
	@Autowired
	LunchService lunchService;
	
	private static final Logger log = LoggerFactory.getLogger(MainController.class);

	@GetMapping("/")
	public String home() {
		return "/home";
	}

	@GetMapping("/menu")
	public String menu(Model model) {
		
		log.info("### Menu 선정 시작 ");

		List<MainVO> lunchList = new ArrayList<> ();
		
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		lunchList = lunchService.selectLunch(df.format(date));
		
		model.addAttribute("menu", lunchList);
		model.addAttribute("date", df.format(date));
		
		log.info("### Menu 선정 완료");

		return "/menu";
	}
	
	@RequestMapping("/history")
	public String history(Model model) {
		
		model.addAttribute("history", lunchService.historySelect());
		
		return "/history";
	}

}