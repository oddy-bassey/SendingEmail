package com.revoltcode.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailRequest {
	
	@Getter @Setter private String name;
	@Getter @Setter private String to;
	@Getter @Setter private String from;
	@Getter @Setter private String subject;
}
