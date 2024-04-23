package com.itbank.components;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class NewPw {
	
	public String getPw() {
		String result = "";
		result = UUID.randomUUID().toString().substring(0, 6);
		
		return result;
		
	}
}
