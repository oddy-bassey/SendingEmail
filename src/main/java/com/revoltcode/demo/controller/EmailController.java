package com.revoltcode.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revoltcode.demo.dto.MailRequest;
import com.revoltcode.demo.dto.MailResponse;
import com.revoltcode.demo.service.EmailService;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@PostMapping("/sendEmail")
	public MailResponse sendEmail(@RequestBody MailRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("Name", request.getName());
		model.put("location", "Abuja, Nigeria.");
		
		return emailService.sendEmail(request, model);
	}
}














