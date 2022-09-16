package com.lunch.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	public String email;
	public String name;
	public String join_date;
	public String use_YN;
	
	public User() {
		
	}
	
	public User(String email, String name, String join_date, String use_YN) {
		this.email = email;
		this.name = name;
		this.join_date = join_date;
		this.use_YN = use_YN;
	}
}
