package com.lunch.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter @Getter
@Entity
@Table(name="lunch_history")
public class MainVO {
	
	@Column(name="dep")
	public String div;
	@Column(name="num") @Id
	public int no;
	public String nation;
	public String menu;
	public String date;

}
