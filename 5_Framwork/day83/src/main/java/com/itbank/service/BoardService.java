package com.itbank.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itbank.model.BoardDAO;
import com.itbank.model.vo.BoardVO;

@Service
public class BoardService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private BoardDAO dao;
	
	@Transactional(readOnly = true)
	public List<BoardVO> selectAll() {
		
		return dao.selectAll();
	}

	public void logTest() {
		logger.error("로그 : 에러");
		logger.warn("로그 : 경고");
		logger.info("로그 : 정보");
		logger.debug("로그 : 디버깅");
		logger.trace("로그 : 추적");
	}
	
	
	@Transactional(rollbackFor = Exception.class)
	public int inserTest() throws Exception {
		dao.insert("테스트1");
		dao.insert("테스트2");
		
		
		int n = 1; 
		
		if (n == 1) {
			throw new  Exception("예외 발생!");
		}
		
		
		dao.insert("테스트3");
		
		return 0;
		
	}
	
	@Transactional(readOnly = true)
	public int addBoard(BoardVO input) {

		return dao.writeBoard(input);
	}
	
	
	@Transactional(readOnly = true)
	public BoardVO viewBoard(int idx) {
		
		return dao.selectOne(idx);
	}
	
	@Transactional(readOnly = true)
	public int delBoard(int idx) {
		
		return dao.delboard(idx);
	}

	@Transactional(readOnly = true)
	public int updateBd(BoardVO input) {
		
		return dao.updateBd(input);
	}
	
	
	
	
}
