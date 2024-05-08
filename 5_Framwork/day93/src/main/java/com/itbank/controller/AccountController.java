package com.itbank.controller;



import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.AccountService;
import com.itbank.vo.AccountVO;


@Controller
@RequestMapping("/")
public class AccountController {
	
	@Autowired
	private AccountService as;
	
	@GetMapping("/")
	public ModelAndView home() {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", as.viewAcc());
		mav.setViewName("home");
		
		return mav;
	}
	
	
	@GetMapping("/account/login")
	public void login() {}
	
	
	@PostMapping("/account/login")
	public ModelAndView login(AccountVO input, HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		String msg = "로그인 성공^^";
		session.setAttribute("user", as.loginAcc(input));

		if(as.loginAcc(input) == null) {
			msg = "로그인 실패!!";
		}
		mav.addObject("row", 1);
		mav.addObject("msg", msg);
		mav.addObject("path", "/");
		mav.setViewName("message");
		
		return mav;
		
	}
	
	@GetMapping("/account/logout")
	public ModelAndView logout(HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "로그아웃 되었습니다.");
		mav.addObject("path", "/");
		mav.addObject("row", 1);
		
		session.removeAttribute("user");
		
		mav.setViewName("message");
		
		return mav;
	}
	
	@GetMapping("/account/signUp")
	public void signUp() {}
	
	@ResponseBody
	@GetMapping("/account/checkId")
	public int checkId(String userid) {
		// 전달받은 id가 DB에 존재하는 지 파악
		// 있으면 0을 없으면 1을 반환한다.
		int row = as.selectAcc(userid);
		
		if(row == 1) {row = 0;}
		else {row = 1;}
		
		
		return row;
	}
	
	@PostMapping("/account/signUp")
	public ModelAndView signUp(AccountVO input) {
		
		ModelAndView mav = new ModelAndView();
		String msg = "회원가입 성공!";
		int row = as.signUp(input);
		if (row == 0) {
			msg = "회원 가입 실패";
		}
		
		mav.addObject("row", row);
		mav.addObject("msg", msg);
		mav.addObject("path", "/");
		mav.setViewName("message");
		
		return mav;
		
	}
	
	
	@GetMapping("/account/myPage")
	public void myPage() {}
	
	@PostMapping("/account/myPage")
	public ModelAndView myPage(AccountVO input, HttpSession session) throws IOException {
		AccountVO user = (AccountVO) session.getAttribute("user");
		input.setIdx(user.getIdx());
		
		ModelAndView mav = new ModelAndView();
		String msg = "정보 수정 성공";
		int row = as.accUpdate(input);
		
		if(row == 0) {
			msg = "정보 수정 실패";
		}
		
		mav.addObject("row", row);
		mav.addObject("msg", msg);
		mav.addObject("path", "/account/logout");
		mav.setViewName("message");
		
		return mav;
	}
	
	@GetMapping("/account/delete")
	public ModelAndView delete(HttpSession session) throws IOException {
		AccountVO user = (AccountVO) session.getAttribute("user");
		ModelAndView mav = new ModelAndView("message");
		
		mav.addObject("row", as.delete(user.getIdx()));
		mav.addObject("msg", "탈퇴 완료");
		mav.addObject("path", "/account/logout");
		
		return mav;
	}
	
}
