package com.lunch.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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

	@GetMapping({ "/menu", "/menu/{idx}" })
	public String menu(Model model, @RequestParam(value = "lunch", defaultValue = "") String lunch,
			@PathVariable("idx") Optional<String> idx) {

		String menu_1 = idx.isPresent() ? idx.get() : lunch;
		List<MainVO> lunchList = new ArrayList<> ();

		lunchList = menu_1.equals("") ? lunchService.selectLunch(lunch) : lunchService.selectLunch(menu_1);

		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		model.addAttribute("menu", lunchList);
		model.addAttribute("date", df.format(date));
		model.addAttribute("menu_1", menu_1);

		return "/menu";
	}

}
