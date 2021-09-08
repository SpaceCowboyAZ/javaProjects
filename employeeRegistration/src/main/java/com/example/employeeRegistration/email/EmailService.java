package com.example.employeeRegistration.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmailService implements EmailSender {
	
	private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(EmailService.class);
	
	private final JavaMailSender mailSender;
	
	@Override
	@Async
	//async so it doesn't block client
	public void send(String to, String email) {
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = 
					new MimeMessageHelper(mimeMessage, "utf-8");
			helper.setText(email, true);
			helper.setTo(to);;
			helper.setSubject("Confirm your email");
			helper.setFrom("dylankharper147@gmail.com");
			mailSender.send(mimeMessage);
			
		} catch (MessagingException e) {
			LOGGER.error("email failed to send", e);
			throw new IllegalStateException("email failed to send");
		}
		
	}

}
