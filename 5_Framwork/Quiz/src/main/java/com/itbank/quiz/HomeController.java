package com.itbank.quiz;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.AccountService;
import com.itbank.vo.AccountVO;

@Controller
public class HomeController {
	
	@Autowired
	private AccountService as;
	
	@GetMapping("/")
	public ModelAndView home() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list", as.getAccount());
		mav.setViewName("home");
		
		return mav;
		
	}
	
	@GetMapping("/acc/login")
	public void login() {}
	
	@PostMapping("/acc/login")
	public String login(AccountVO input, HttpSession session) {
		
		AccountVO user = as.login(input);
		String msg = "";
		
		if (user != null) {
			session.setAttribute("user", user);
			msg = "redirect:/";
		}
		
		return msg;
	}
	
	@GetMapping("/acc/logout")
	public String logout(HttpSession session) {
		
		session.removeAttribute("user");
		
		return "redirect:/";
		
	}
	
	@GetMapping("/acc/signUp")
	public void signUp() {}
	
	@PostMapping("/acc/signUp")
	public String signUp (AccountVO input) {
		
		as.addAcc(input);
		return "redirect:/";

		
	}
	
	
	@GetMapping("/acc/myPage")
	public void myPage() {}

	
	@PostMapping("/acc/update")
	public String myPage(AccountVO input, HttpSession session) {
		AccountVO user = (AccountVO) session.getAttribute("user");
		input.setIdx(user.getIdx());
		
		as.updateAcc(input);
		
		return "redirect:/acc/logout";
	}
	
	@GetMapping("/acc/delete/{idx}")
	public String deleteAcc(@PathVariable int idx) {
		
		as.delAcc(idx);
		
		return "redirect:/acc/logout";
	}
	
}
