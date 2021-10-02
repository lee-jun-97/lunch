package com.lunch.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lunch.vo.MainVO;

import lombok.NoArgsConstructor;

@Service
@NoArgsConstructor
public class LunchService {
	
	public List<MainVO> selectLunch() {

		List<MainVO> lunchList = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			MainVO mainvo = new MainVO();
			String lunch = selectMenu();

			mainvo.no = i+1;
			
			if(mainvo.no == 1) {
				mainvo.div = "메인";
			} else {
				mainvo.div = "후보";
			}
			switch (lunch) {
			case "korean":
				mainvo.menu = "한식";
				mainvo.store = selectKoreanFoodStore();
				break;
			case "china":
				mainvo.menu = "중식";
				mainvo.store = selectChinaFoodStore();
				break;
			case "europe":
				mainvo.menu = "양식";
				mainvo.store = selectEuropeFoodStore();
				break;
			}
			
			// 가게 중복 방지 로직
			if( i > 0 ) {
				if(mainvo.store == lunchList.get(i-1).store) {
					i--;
				} else {
					if(i > 1 && mainvo.store == lunchList.get(i-2).store) {
						i--;
					} else {
						lunchList.add(mainvo);						
					}
				}
			} else {
				lunchList.add(mainvo);								
			}
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

}
