package com.lunch.service;

import java.util.List;

import com.lunch.vo.Menu;

public interface MailService {
	
	public void mailSend() throws Exception;
	public String makeBody(int seq, List<Menu> list);

}
