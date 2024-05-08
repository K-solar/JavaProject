package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.AccountDAO;
import com.itbank.vo.AccountVO;

@Service
public class AccountService {
	
	@Autowired
	private AccountDAO dao;
	
	public List<AccountVO> viewAcc() {
		
		return dao.selectAll();
	}

	public AccountVO loginAcc(AccountVO input) {
		
		return dao.selectOne(input);
	}

	public int signUp(AccountVO input) {
		
		return dao.insert(input);
	}

	public int accUpdate(AccountVO input) {
		
		return dao.update(input);
	}

	public int delete(int idx) {
		
		return dao.delete(idx);
	}

	public int selectAcc(String userid) {
		
		return dao.selectId(userid);
		
	}
	
	
}
