package com.revoltcode.demo.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.revoltcode.demo.dto.MailRequest;
import com.revoltcode.demo.dto.MailResponse;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private Configuration config;
	
	public MailResponse sendEmail(MailRequest request, Map<String, Object> model) {
		
		MailResponse response = new MailResponse();
		MimeMessage message = sender.createMimeMessage();
		
		try {
			//set mediaType
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			
			//add attcahment
			helper.addAttachment("tc.jpg", new ClassPathResource("tc.jpg"));
			
			Template template = config.getTemplate("email-template2.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
			
			//set Email parameters on MimeMessageHelper object
			helper.setTo(request.getTo());
			helper.setText(html, true);
			helper.setSubject(request.getSubject());
			helper.setFrom(request.getFrom());
			sender.send(message);
			
			//create successful response!
			response.setMessage("Mail sent to : " + request.getTo());
			response.setStatus(Boolean.TRUE);
			
		}catch(MessagingException | IOException | TemplateException e) {
			
			//create failed response!
			response.setMessage("Failed to send to : " + request.getTo());
			response.setStatus(Boolean.FALSE);
		}
		
		return response;
	}
}
















