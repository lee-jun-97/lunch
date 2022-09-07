package com.lunch.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
@Table(name="lunch_history")
public class History {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int seq;
	public String menu;
	public String date;
	
	public String toString() {
		return "History : [ "+ date + " : " + menu + " ]";
	}

}
