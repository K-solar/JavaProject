package com.controller.day71;

import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.day71.model.vo.PersonVO;

@Controller
@RequestMapping("/ex04")
public class Ex04Controller {
	
	@GetMapping("/test1")	// ex04/test1으로 요청이 들어오면 실행
	public void test1() {}	// void는 요청 uri가 view 이름이 된다.
							// 즉, /WEB-INF/views/ex04/test1.jsp로 포워드
	
	@PostMapping("/test1") 
	public String test1 (Model model, PersonVO per) {
		
		String name = per.getName();
		Double ht = per.getHeight();
		Date birth = per.getBirth();
		int score = per.getScore();
		
		String msg = name + "님은 ";
		msg += ht + "cm의 키를 가지고 있으며 생년월일은 " + birth + "이고 보유한 토익점수는 " + score + "입니다.";
		
		
		model.addAttribute("msg", msg);

		return "ex04/test1_result";
	}
	
}
