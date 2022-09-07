package com.lunch.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "menu_list")
public class Menu {

	@Id
	public String menu;
	
}
