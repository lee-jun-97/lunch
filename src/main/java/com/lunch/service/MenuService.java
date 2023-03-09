package com.lunch.service;

import java.util.List;

import com.lunch.vo.Menu;

public interface MenuService {
	
	public List<Menu> selectLunch(String nation);
	public List<Menu> selectLunch();
	public void saveMenu(Menu menu);
	public boolean validation(String input);
	public List<Menu> addResult(List<Menu> list, int n);
	public boolean isListSizeZero(List<Menu> list);
}
