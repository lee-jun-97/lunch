package com.lunch.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="lunch_history")
public class LunchHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int seq;
	public String first_menu = null;
	public String second_menu = null;
	public String third_menu = null;
	public String select_date;
	
	public LunchHistory() {
		
	}
	
	public LunchHistory(String first_menu, String second_menu, String third_menu, String select_date) {
		this.first_menu = first_menu;
		this.second_menu = second_menu;
		this.third_menu = third_menu;
		this.select_date = select_date;
	}
	
}
