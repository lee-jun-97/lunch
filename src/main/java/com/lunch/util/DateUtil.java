package com.lunch.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateUtil {
	
	public String createDatetime() {
		
		LocalDateTime now = LocalDateTime.now(); 
		DateTimeFormatter dtFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"); 
		
		return now.format(dtFmt);
	}
	
	public String createDate() {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		return sdf.format(date);
	}
	

}
