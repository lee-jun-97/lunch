package com.lunch.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

public class DateUtilTest {
	
	@Test
	public void createDateTest() throws Exception {
		System.out.println(createDate());
	}
	
	public String createDate() {
		
		LocalDateTime now = LocalDateTime.now(); 
		DateTimeFormatter dtFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"); 
		
		return now.format(dtFmt);
	}

}
