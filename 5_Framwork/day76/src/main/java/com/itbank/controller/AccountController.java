package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService as;
	
	@GetMapping("/accinfo")
	public ModelAndView accinfo() {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("acclist", as.getAcc());
		
		mav.setViewName("/account/accinfo");
		
		return mav;
	}
	
}
