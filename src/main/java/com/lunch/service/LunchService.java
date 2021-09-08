package com.lunch.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lunch.vo.MainVO;

@Service
public class LunchService {
		
	List<String> menuList = new ArrayList<String>();
	
	MainVO mainvo = new MainVO();
	
	String store ;
	
	public LunchService() {
		
		this.menuList.add("한식");
		this.menuList.add("중식");
		this.menuList.add("양식");
		
	}
	
	public MainVO selectLunch() {
		
		Collections.shuffle(this.menuList);
		
		mainvo.menu = this.menuList.get(0);
		
		switch(mainvo.menu) {
		case "한식" : mainvo.store = selectKoreanFoodStore(); break;
		case "중식" : mainvo.store = selectChinaFoodStore(); break;
		case "양식" : mainvo.store = selectEuropeFoodStore(); break;
		}
		
		return mainvo;
	}
	
	public String selectKoreanFoodStore() {
		
		List<String> storeList = new ArrayList<String>();
		
		storeList.add("국전");
		storeList.add("콩나물국밥");
		storeList.add("순대국밥");
		storeList.add("명동할머니");
		storeList.add("마늘보쌈");
		storeList.add("광시");
		storeList.add("소나기");
		storeList.add("물갈비집");
		storeList.add("새마을식당");
		storeList.add("순대국밥");
		storeList.add("찜통");
		storeList.add("설렁탕");
		storeList.add("육대장");
		storeList.add("곰탕");
		storeList.add("부대찌개");
		storeList.add("순두부");
		
		Collections.shuffle(storeList);
		
		return storeList.get(0);
	}
	
	public String selectChinaFoodStore() {
		
		List<String> storeList = new ArrayList<String>();
		
		storeList.add("팔당반점");
		storeList.add("매화");
		storeList.add("강남짬뽕");
		
		Collections.shuffle(storeList);
		
		return storeList.get(0);
	}
	
	public String selectEuropeFoodStore() {
		
		List<String> storeList = new ArrayList<String>();
		
		storeList.add("국전 파스타");
		storeList.add("지하 돈가스 집");
		
		Collections.shuffle(storeList);
		
		return storeList.get(0);
	}

}
