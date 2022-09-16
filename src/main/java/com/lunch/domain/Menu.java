package com.lunch.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu_list")
public class Menu {

	@Id
	public String menu;
	
	public Menu() {
		
	}
	
	public Menu(String menu) {
		this.menu = menu;
	}
	
}






