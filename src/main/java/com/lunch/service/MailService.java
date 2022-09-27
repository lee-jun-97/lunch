package com.lunch.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.lunch.domain.Menu;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MailService {
	
	private JavaMailSender mSender;
	private MenuService menuService;
//	private Environment env;
	// 테스트만 진행 후 Spring Batch 적용 예정
	
	@PostConstruct
	public void mailSend() {
		
		Properties properties = System.getProperties();
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			@SuppressWarnings("unused")
			protected PasswordAuthentication getPasswordAuthenctication() {
				return new PasswordAuthentication("email 주소", "해당 email 패스워드");
			}
		});
		
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
//		List<Menu> menu = menuService.selectLunch();
		
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			
			@SuppressWarnings("static-access")
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				//		message.setFrom(env.getProperties().getProperty("spring.mail.username"));
				//		message.setTo("yuog12@naver.com");
				helper.setFrom("yuog12@gmail.com");
				helper.setTo("yuog12@naver.com");
				helper.setSubject(df.format(date) + " 점심 메뉴");
				for(Menu i : menuService.selectLunch()) {
					helper.setText(i.menu);
				}
				
			}
		};
		
		mSender.send(preparator);
	}

}