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
	private AccountService as;
	
	@GetMapping()
	public ModelAndView viewAcc() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list", as.viewAcc());
		mav.setViewName("/account/list");
		
		return mav;
		
	}
}
