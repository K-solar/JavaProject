package com.itbank.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.vo.BoardVO;
import com.itbank.service.BoardService;

@Controller
public class BoardController {

	
	@Autowired
	private BoardService bs;
	
	@GetMapping("/")
	public ModelAndView home() {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("list", bs.selectAll());
		mav.setViewName("board/list");
		
		return mav;
	}
	
	@GetMapping("/log")
	public String logTest() {
		bs.logTest();
		
		return "redirect:/";
	}
	
	
	@GetMapping("/transaction")
	public String transactionTest() throws Exception {
		bs.inserTest();
		
		return "redirect:/";
	}
	
	@GetMapping("/board/add")
	public void add() {}
	
	@PostMapping("/board/add")
	public ModelAndView add(BoardVO input) {
		ModelAndView mav = new ModelAndView();
		
		String msg = "";
		msg = (bs.addBoard(input) == 1) ? "작성 완료" : "작성실패";
		
		mav.addObject("msg", msg);
		mav.setViewName("message");
		
		return mav;
	}
	
	
	@GetMapping("/board/view/{idx}")
	public ModelAndView view(@PathVariable int idx) {
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("row", bs.viewBoard(idx));
		mav.setViewName("/board/view");
		
		return mav;
	}
	
	
	
	@GetMapping("/board/delete/{idx}")
	public ModelAndView delete(@PathVariable int idx) {
		
		ModelAndView mav = new ModelAndView();
		
		String msg = "";
		msg = (bs.delBoard(idx) == 1) ? "삭제 완료" : "삭제 실패";
		
		mav.addObject("msg", msg);
		mav.setViewName("message");
		
		return mav;
	}
	
	@GetMapping("/board/update/{idx}")
	public ModelAndView update(@PathVariable int idx) {
		
		ModelAndView mav = new ModelAndView();
		
		
		mav.addObject("row", bs.viewBoard(idx));
		mav.setViewName("/board/update");
		
		return mav;
	}
	
	
	@PostMapping("/board/update")
	public ModelAndView update(BoardVO input) {
		
		ModelAndView mav = new ModelAndView();
		
		String msg = "";
		msg = (bs.updateBd(input) == 1) ? "수정 완료" : "수정 실패";
		
		mav.addObject("msg", msg);
		mav.setViewName("message");
		
		return mav;
	}
	
}
