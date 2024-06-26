package com.itbank;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.itbank.model.TestDAO;
import com.itbank.service.TestService;

@SpringBootTest
class Day94ApplicationTests {
	
	@Autowired
	private TestService ts;
	
	@Autowired
	private TestDAO dao;
	
	@Test
	void serviceTest() {
		
		System.out.println("ts = " + ts);
		System.out.println("메서드 = " + ts.total(5));
		
	}
	
	@Test
	void daoTest() {
		System.out.println("dao = " + dao);
		System.out.println("테스트 = " + dao.test());
		
	}
	
	

}
