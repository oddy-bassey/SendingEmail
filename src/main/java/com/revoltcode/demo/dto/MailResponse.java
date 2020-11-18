package com.revoltcode.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailResponse {
	
	@Getter @Setter private String message; 
	@Getter @Setter private boolean status;
}
