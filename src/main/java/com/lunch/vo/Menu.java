package com.lunch.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu_list")
public class Menu {

	@Id
	public String menu;
	public String nation;
	
	public Menu() {
		
	}
	
	public Menu(String menu, String nation) {
		this.menu = menu;
		this.nation = nation;
	}
	
}






