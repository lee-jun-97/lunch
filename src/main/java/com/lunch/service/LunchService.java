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
			String lunch = selectMenu();
			
			mainvo.setDate(df);

			mainvo.setNo(i+1);
			
			if(mainvo.no == 1) {
				mainvo.setDiv("메인");
			} else {
				mainvo.setDiv("후보");
			}
			switch (lunch) {
			case "korean":
				mainvo.setMenu("한식");
				mainvo.setStore(selectKoreanFoodStore());
				break;
			case "china":
				mainvo.setMenu("중식");
				mainvo.setStore(selectChinaFoodStore());
				break;
			case "europe":
				mainvo.setMenu("양식");
				mainvo.setStore(selectChinaFoodStore());
				break;
			}
			
			// 가게 중복 방지 로직
			if( i > 0 ) {
				if(mainvo.getStore() == lunchList.get(i-1).store) {
					i--;
				} else {
					if(i > 1 && mainvo.getStore() == lunchList.get(i-2).store) {
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
			
			log.info("### Lunch Menu : " + i.menu);
			log.info("### Lunch Store : " + i.store);
			
		}
		
		return lunchList;
	}
	
	public String selectMenu() {
		
		List<String> menuList = new ArrayList<>();
		
		menuList.add("korean");
		menuList.add("china");
		menuList.add("europe");
		
		Collections.shuffle(menuList);
		
		String menu = menuList.get(0);
		
		return menu;
	}

	public String selectKoreanFoodStore() {

		List<String> storeList = new ArrayList<>();

		storeList.add("국제전자상가");
		storeList.add("전주콩나물국밥");
		storeList.add("순대국밥");
		storeList.add("명동 할머니 국수");
		storeList.add("마늘 보쌈");
		storeList.add("광시");
		storeList.add("소나기");
		storeList.add("백년 물갈비");
		storeList.add("새마을 식당");
		storeList.add("찜통");
		storeList.add("설렁탕");
		storeList.add("육대장");
		storeList.add("나주 곰탕");
		storeList.add("부대찌개");
		storeList.add("순두부");

		Collections.shuffle(storeList);

		return storeList.get(0);
	}

	public String selectChinaFoodStore() {

		List<String> storeList = new ArrayList<String>();

		storeList.add("팔당 반점");
		storeList.add("매화");
		storeList.add("강남 짬뽕");

		Collections.shuffle(storeList);

		return storeList.get(0);
	}

	public String selectEuropeFoodStore() {

		List<String> storeList = new ArrayList<String>();

		storeList.add("국제전자상가 파스타");
		storeList.add("미토요");
		storeList.add("양계장집");

		Collections.shuffle(storeList);

		return storeList.get(0);
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
