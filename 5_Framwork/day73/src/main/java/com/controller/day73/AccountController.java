package com.controller.day73;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.vo.AccountVO;
import com.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService as;
	
	
	
	@GetMapping("/view")
	public ModelAndView view() {
		ModelAndView mav = new ModelAndView();
		
		// mav.addObject("ver", as.test());
		mav.addObject("list", as.list());
		mav.setViewName("account/view");
		
		return mav;
		
	}
	
	
	@GetMapping("/add")
	public void add() {}
	
	
	@PostMapping("/add")
	public String add(Model model, AccountVO input) {
		
		int row = as.addAcc(input);
		String msg = (row == 0) ? "등록 실패!" : "등록 성공 ^^";
		
		model.addAttribute("msg", msg);
		// 2. model은 request를 대체한다. 즉, forward에만 유지됨
		
		//	1. view 이름 접두어로 redirect: 를 작성 시 리다이렉트 된다.	
			return "redirect:/account/view";
	}
	
	
	@GetMapping("/delete")
	public ModelAndView delete(int idx) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("row", as.delete(idx));
		mav.setViewName("/account/delete");
		
		return mav;
	}
	
	
	@GetMapping("/update")
	public ModelAndView update(int idx) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("idx", idx);
		mav.setViewName("/account/update");
		
		return mav;
	}
	
	@PostMapping("/update")
	public ModelAndView update(AccountVO input) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("row", as.update(input));
		mav.setViewName("/account/update");
		
		return mav;
	}

	
	
	
	
	
	
}
