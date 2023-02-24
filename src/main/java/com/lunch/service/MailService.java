package com.lunch.service;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.lunch.domain.Menu;
import com.lunch.domain.User;
import com.lunch.repository.UserRepository;
import com.lunch.util.DateUtil;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MailService {
	
	private static final Logger logger = LoggerFactory.getLogger(MailService.class);

	private Environment env;
	private UserRepository userRepo;
	private MenuService menuService;
	private HistoryService historyService;
	private DateUtil dateUtil;
	
	// 매주 월~금 오전 9시 실행
	@Scheduled(cron = "0 0 9 * * 1-5")
	public void mailSend() throws Exception {
		
		Properties props = System.getProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.stmp.protocol", 25);
		props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
		
		Session session = Session.getDefaultInstance(props);
		
		MimeMessage msg = new MimeMessage(session);
		
		Transport transport = session.getTransport();
		
		try {
			
			List<Menu> menuList = menuService.selectLunch();
			
			msg.setFrom(new InternetAddress(env.getProperty("spring.mail.username"), "TEST"));
			msg.setContent(makeBody(1, menuList), "text/html;charset=euc-kr");
			msg.setSubject(dateUtil.createDate() + " 추천 메뉴");
			transport.connect(env.getProperty("spring.mail.host"), env.getProperty("spring.mail.username"), env.getProperty("spring.mail.password"));
			
			List<User> userList = userRepo.findAll();
			InternetAddress[] toArr = new InternetAddress[userList.size()];
			for(int i=0; i<userList.size(); i++) {
				toArr[i] = new InternetAddress(userList.get(i).email);
			}
			
			msg.setRecipients(Message.RecipientType.TO, toArr);
			
			transport.sendMessage(msg, msg.getAllRecipients());
			
			historyService.mailHistoryInsert(userList, menuList);
		} catch(Exception e) {
			logger.warn(e.getMessage());
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
