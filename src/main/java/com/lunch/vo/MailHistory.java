package com.lunch.vo;

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
@Table(name="mail_history")
public class MailHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int seq;
	public String email;
	public String name;
	public String first_menu;
	public String second_menu;
	public String third_menu;
	public String send_date;
	
	public MailHistory() {
		
	}
	
	
	public MailHistory(int seq, String email, String name, String first_menu, String second_menu, String third_menu, String send_date) {
		this.seq = seq;
		this.email = email;
		this.name = name;
		this.first_menu = first_menu;
		this.second_menu = second_menu;
		this.third_menu = third_menu;
		this.send_date = send_date;
	}

}
