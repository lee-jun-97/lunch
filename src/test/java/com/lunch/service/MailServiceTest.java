package com.lunch.service;

import java.util.Properties;

import org.hibernate.cfg.Environment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class MailServiceTest {
	
	private Properties mailSender = Environment.getProperties();
	
	@Test
	public void mailSend() {
		
		Assertions.assertEquals(mailSender.getProperty("mail.from"), "yuog12@gmail.com");
		
	}

}
