package com.lunch.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lunch.service.LunchService;
import com.lunch.vo.MainVO;

@Controller
public class MainController {
	
	@Autowired
	LunchService lunchService;

	@GetMapping("/")
	public String main() {
		return "/main";
	}

	@GetMapping("/menu")
	public String menu(Model model) {

		List<MainVO> lunchList = new ArrayList<> ();

		lunchList = lunchService.selectLunch();

		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		model.addAttribute("menu", lunchList);
		model.addAttribute("date", df.format(date));

		return "/menu";
	}

}
