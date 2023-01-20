package com.lunch.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static String createDate() {
		
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		return df.format(date);
	}

}
