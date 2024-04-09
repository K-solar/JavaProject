package com.controller.day74;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.vo.BoardVO;
import com.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardService bs;
	
	
	@GetMapping("/write")
	public void addWrite() {}
	
	
	
	@PostMapping("/write")
	public ModelAndView addWrite(BoardVO input) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("row", bs.write(input));
		mav.setViewName("/write");
		
		return mav;
	}
	
	// Spring은 url에 작성한 내용도 파라미터로 받아 처리가능
	// - url 중간에 있는 값도 받아서 처리가능
	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable int idx) {
		

		ModelAndView mav = new ModelAndView();
		mav.addObject("select", bs.selectView(idx));
		mav.setViewName("/board/view");

		return mav;
	}
	
	
	@GetMapping("/delete/{idx}")
	public ModelAndView delete(@PathVariable int idx) {
		
		ModelAndView mav = new ModelAndView();
		
		
		mav.addObject("row", bs.delete(idx));
		mav.setViewName("/board/delete");
		
		return mav;
		
		
	}
	
	@GetMapping("/update/{idx}")
	public ModelAndView update(@PathVariable int idx) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("row", bs.selectOne(idx));
		mav.setViewName("/board/update");
		
		return mav;
	}
	
	@PostMapping("/update/{idX}")
	public ModelAndView update(BoardVO input) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("updat", bs.update(input));
		mav.setViewName("/board/update");
		
		return mav;
	}
	
	
	
	
}
