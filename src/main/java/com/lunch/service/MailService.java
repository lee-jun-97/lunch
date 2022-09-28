package com.lunch.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.lunch.domain.Menu;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MailService {
	
	private Environment env;
	private MenuService menuService;
	
	// 테스트만 진행 후 Spring Batch 적용 예정
	@PostConstruct
	public void mailSend() throws Exception {
		
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		Properties props = System.getProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.stmp.protocol", 25);
		props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
		
		Session session = Session.getDefaultInstance(props);
		
		MimeMessage msg = new MimeMessage(session);
		
		Transport transport = session.getTransport();
		
		try {
			
			msg.setFrom(new InternetAddress(env.getProperty("spring.mail.username"), "TEST"));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress("***@***"));
			msg.setSubject(df.format(date) + " 점심 메뉴");
			msg.setContent(makeBody(1, menuService.selectLunch()), "text/html;charset=euc-kr");
			
			transport.connect(env.getProperty("spring.mail.host"), env.getProperty("spring.mail.username"), env.getProperty("spring.mail.password"));
			transport.sendMessage(msg, msg.getAllRecipients());
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
				transport.close();
		}
		
	}
	
	public String makeBody(int seq, List<Menu> list) {
		
		String body = "";

		for(Menu i : list) {
			body += "<p>";
			body += (seq++ + ". " + i.menu);
			body += "</p>";
			body += "\n";
		}
		
		return body;
	}

}
