package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.AccountDAO;
import com.model.vo.AccountVO;


@Service
public class AccountService {
	
	@Autowired
	private AccountDAO dao;
	
	public List<AccountVO> list() {
		
		
		return dao.selectAll();
	}

	public String test() {
		return dao.test();
	}

	public int addAcc(AccountVO input) {

		return dao.insert(input);
		
	}

	public int delete(int idx) {
		return dao.delete(idx);
	}

	public int update(AccountVO input) {
		
		return dao.update(input);
	}
	
	
}
