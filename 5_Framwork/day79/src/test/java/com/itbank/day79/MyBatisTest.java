package com.itbank.day79;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itbank.model.BoardDAO;
import com.itbank.model.vo.BoardVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MyBatisTest {
	
	@Autowired
	private BoardDAO dao;
	
	@Test
	public void connection() {
		String banner = "Oracle Database 18c Express Edition Release 18.0.0.0.0 - Production";
		
		assertEquals("접속성공", banner, dao.test());
	}
	
	@Test
	public void selectTest() {
		//assertNotNull(dao.selectAll());
	}
	
	@Test
	public void inserTest() {
		BoardVO input = new  BoardVO();
		
		input.setTitle("Mybatis 테스트");
		input.setUser_idx(1014);
		input.setContents("싸고 맛있는 아메리카노");

		assertEquals("추가 성공", 1, dao.insert(input));
		
	}
	
}
