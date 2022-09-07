package com.lunch.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Setter;

@Entity
@Setter
@Table(name = "menu_list")
public class Menu {

	@Id
	public String menu;
	
}
