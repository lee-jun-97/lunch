package com.lunch.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "menu_list")
public class Menu {

	@GeneratedValue(strategy=GenerationType.AUTO)
	public int seq;
	@Id
	public String menu;
	
	public Menu(String menu) {
		this.menu = menu;
	}
}
