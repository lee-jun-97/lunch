package com.lunch.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DateUtilTest {
	
	@Test
	public void createDateTest() throws Exception {
		assertEquals("2023-01-20", DateUtil.createDate());
	}

}
