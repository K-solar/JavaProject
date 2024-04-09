package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.BoardDAO;
import com.model.vo.BoardVO;

@Service
public class BoardService {
	
	@Autowired
	private BoardDAO dao;
	
	public int write(BoardVO input) {
		
		return dao.write(input);
	}

	public BoardVO selectOne(int idx) {
		
		return dao.selectOne(idx);
	}

	public int delete(int idx) {
			
		return dao.delete(idx);
	}

	public int update(BoardVO input) {
		
		return dao.update(input);
	}

	public BoardVO selectView(int idx) {
		
		return dao.selectView(idx);
	}

	public Map<String, Object> getBoards(Integer reqPage) {
		
		if (reqPage == null) {
			reqPage = 1;
		}
	
		
		Paging pg = new Paging(reqPage, dao.totalBoard());

		List<BoardVO> list = dao.selectAll(pg);
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("pg", pg);
		map.put("list", list);
		
		return map;
	}
	
}
