package com.controller.day71;

import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.day71.model.vo.PersonVO;

@Controller
@RequestMapping("/ex05")
public class Ex05Controller {
	
	@GetMapping		// view는 /WEB-INF/views/ex05.jsp
	public void ex05() {}
	
	
	@PostMapping
	public String ex05(Model model, @RequestParam Map<String, Object> map) {
		// 컨트롤러 메서드 파라미터에서 Map은 여러 용도로 사용되는데
		// 요청 파라미터라는 어노테이션을 붙이지 않으면 파라미터를 받을 수 없다.
		
		/*
		map.forEach((String  k, Object v) -> {
			
		});
		model.addAttribute("map", map);
		*/
		

		Set<String> keys = map.keySet();
		String msg = "";
		
		for (String k : keys) {
			msg += map.get(k) + "   ";
		}
		
		model.addAttribute("msg", msg);
		
		
		return "ex05_result";
	}


	@GetMapping("/test1")
	public String ex06() {
		
		return "ex06";
	}
	
	@PostMapping("/test1")
	public ModelAndView ex06(PersonVO per) {
		
		ModelAndView mav = new ModelAndView();
		
		String msg = "불합격";
		
		if(per.getScore() >= 600) {
			msg = "합격";
		}
		
		mav.addObject("msg", msg);
		mav.setViewName("ex06_result");
		
		return mav;
	}
	
	
}
