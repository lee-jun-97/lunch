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

}
