package com.lunch.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
@Table(name="lunch_history")
public class History {
	
	public String dep;
	public int num;
	public String menu;
	@Id
	public String date;
	
	public String toString() {
		return "History : [ " + dep + ", " + num + ", " + menu + ", " + date + " ]";
	}

}
