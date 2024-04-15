package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.vo.BoardVO;
import com.itbank.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService bs;
	
	@GetMapping("/list")
	public ModelAndView list() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("list", bs.getBoards());
		mav.setViewName("/board/list");
		
		return mav;
	}
	
	@GetMapping("/add")
	public void add() {}
	
	@PostMapping("/add")
	public ModelAndView add(BoardVO input) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("result", bs.insertBd(input));
		mav.setViewName("/board/add");
		
		return mav;
	}
	
	
	
}
