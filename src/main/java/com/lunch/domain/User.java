package com.lunch.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

	@Id
	public String email;
	public String name;
	public String join_date;
	public String use_YN;
}
