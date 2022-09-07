package com.lunch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lunch.domain.History;
import com.lunch.domain.Menu;

@Configuration
public class BeanConfig {
	
	@Bean
	public Menu Menu() {
		return new Menu();
	}
	
	@Bean
	public History History() {
		return new History();
	}

}
