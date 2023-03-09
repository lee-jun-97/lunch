package com.lunch.vo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	public String email;
	public String name;
	public String join_date;
	public String dead_date;
	public String use_YN;
	
	public User() {
		
	}
	
	public User(String email, String name, String join_date, String use_YN) {
		this.email = email;
		this.name = name;
		this.join_date = join_date;
		this.dead_date = null;
		this.use_YN = use_YN;
	}
	
	public User(String email, String name, String join_date, String dead_date, String use_YN) {
		this.email = email;
		this.name = name;
		this.dead_date = dead_date;
		this.use_YN = use_YN;
	}
}
