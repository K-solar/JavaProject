package com.controller.day72;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.vo.AccountVO;
import com.service.QuizService;

@Controller
public class QuizController {
	
	@Autowired
	private QuizService qs;
	
	@GetMapping("/quiz")
	public void quiz() {}
	
	@PostMapping("/quiz")
	public ModelAndView quiz(AccountVO input) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("msg", qs.login(input));
		mav.setViewName("quiz_result");
		
		return mav;
	}
	
}
