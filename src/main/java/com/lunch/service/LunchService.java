package com.lunch.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lunch.repository.LunchRepository;
import com.lunch.vo.MainVO;

@Service
public class LunchService {
	
	@Autowired
	private LunchRepository lunchRepo ;
	
	private static final Logger log = LoggerFactory.getLogger(LunchService.class);
	
	public List<MainVO> selectLunch(String df) {

		List<MainVO> lunchList = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			MainVO mainvo = new MainVO();
			String lunch = selectNation();
			
			mainvo.setDate(df);

			mainvo.setNo(i+1);
			
			if(mainvo.no == 1) {
				mainvo.setDiv("메인");
			} else {
				mainvo.setDiv("후보");
			}
			switch (lunch) {
			case "korean":
				mainvo.setNation("한식");
				mainvo.setMenu(selectKoreanFood());
				break;
			case "china":
				mainvo.setNation("중식");
				mainvo.setMenu(selectChinaFood());
				break;
			case "europe":
				mainvo.setNation("양식");
				mainvo.setMenu(selectEuropeFood());
				break;
			}
			
			// 가게 중복 방지 로직
			if( i > 0 ) {
				if(mainvo.getMenu() == lunchList.get(i-1).menu) {
					i--;
				} else {
					if(i > 1 && mainvo.getMenu() == lunchList.get(i-2).menu) {
						i--;
					} else {
						lunchList.add(mainvo);
					}
				}
			} else {
				lunchList.add(mainvo);
			}
		}
		
		for(MainVO i : lunchList) {
			
			// DB History Insert
			this.historyInsert(i);
			
			log.info("### Lunch Menu : " + i.getNation());
			log.info("### Lunch Store : " + i.getMenu());
			
		}
		
		return lunchList;
	}
	
	public String selectNation() {
		
		List<String> nationList = new ArrayList<>();
		
		nationList.add("korean");
		nationList.add("china");
		nationList.add("europe");
		
		Collections.shuffle(nationList);
		
		String nation = nationList.get(0);
		
		return nation;
	}

	public String selectKoreanFood() {

		List<String> menuList = new ArrayList<>();

		menuList.add("콩나물국밥");
		menuList.add("김치찌개");
		menuList.add("순댓국");
		menuList.add("국수");
		menuList.add("마늘 보쌈");
		menuList.add("불고기");
		menuList.add("곰탕");
		menuList.add("새마을 식당");
		menuList.add("설렁탕");
		menuList.add("육개장");
		menuList.add("부대찌개");
		menuList.add("순두부 찌개");

		Collections.shuffle(menuList);

		return menuList.get(0);
	}

	public String selectChinaFood() {

		List<String> menuList = new ArrayList<String>();

		menuList.add("짜장면");
		menuList.add("짬봉");
		menuList.add("볶음밥");
		menuList.add("탕수육");
		menuList.add("간짜장");

		Collections.shuffle(menuList);

		return menuList.get(0);
	}

	public String selectEuropeFood() {

		List<String> menuList = new ArrayList<String>();

		menuList.add("파스타");
		menuList.add("리조또");
		menuList.add("돈가스");

		Collections.shuffle(menuList);

		return menuList.get(0);
	}
	
	public void historyInsert(MainVO mainvo) {
		
		log.info("### Insert Start");
		log.info("### MainVo : " + mainvo.toString());
		lunchRepo.save(mainvo);
		log.info("### Insert End");
		
	}
	
	public List<MainVO> historySelect() {
		
		log.info("### History 조회 Start");
		List<MainVO> historyList = lunchRepo.findAll();
		log.info("### History 조회 End");
		
		return historyList ;
	}

}
