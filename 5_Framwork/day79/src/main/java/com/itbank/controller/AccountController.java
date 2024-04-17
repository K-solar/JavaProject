package com.itbank.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.vo.AccountVO;
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
	
	@GetMapping("/login")
	public void login() {}
	
	@PostMapping("/login")
	public String login(AccountVO user, HttpSession session) {
		
		user = as.login(user);
		
		if (user != null) {
			session.setAttribute("user", user);
		}
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/myPage")
	public void myPage() {}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/signUp")
	public void signUp() {}
	
	@PostMapping("/signUp")
	public String signUp(AccountVO input) {
		as.addAccount(input);
		
		return "redirect:/account/login";
	}
	
	@GetMapping("/findPw")
	public void findPw() {}
	
	
	@PostMapping("/findPw")
	public ModelAndView findPw(AccountVO input) {
		
		ModelAndView mav = new ModelAndView();
		String msg = "";
		if(as.findAcc(input) == null) { 
			msg = "ID 또는 이메일을 정확하게 기입해주세요";
			mav.addObject("msg", msg);
		}
		else {
			mav.addObject("newPw", as.resetPw(input));
		}
		
		
		mav.setViewName("/account/findPw");
		
		return mav;
	}
	
	
	@GetMapping("/update/{idx}")
	public ModelAndView update(@PathVariable int idx) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("row", as.selectAcc(idx));
		mav.setViewName("/account/update");
		
		return mav;
	}
	
	
	@PostMapping("/update/{idx}")
	public ModelAndView update(@PathVariable int idx, AccountVO input) {
		ModelAndView mav = new ModelAndView();
		
		
		
		mav.addObject("num", as.update(input));
		mav.setViewName("account/update");
		
		return mav;
		
	}
	
	
	@GetMapping("/delete/{idx}")
	public ModelAndView delete(@PathVariable int idx) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("num", as.delAcc(idx));
		mav.setViewName("/account/delete");
		
		
		return mav;
	}
	
	
	
	
}
