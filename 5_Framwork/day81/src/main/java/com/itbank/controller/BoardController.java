package com.itbank.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.vo.BoardVO;
import com.itbank.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService bs;
	
	@GetMapping("/list")
	public ModelAndView list(@RequestParam Map<String, Object> param) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("map", bs.getBoards(param));
		mav.setViewName("board/list");
		
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
	
	@GetMapping("/delete/{idx}")
	public String delete(@PathVariable int idx) {
		bs.delBoard(idx);
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable int idx) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("row", bs.getboard(idx));
		mav.setViewName("board/view");
		
		return mav;
	}

	@GetMapping("/update/{idx}")
	public ModelAndView update(@PathVariable int idx) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("row", bs.getboard(idx));
		mav.setViewName("board/add");
		
		return mav;
	}

	@PostMapping("/update/{idx}")
	public String update(BoardVO input) {
		bs.updateBoard(input);
		
		return "redirect:/board/list";
	}
	
}
