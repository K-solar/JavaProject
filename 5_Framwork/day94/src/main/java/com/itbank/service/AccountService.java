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
	
	
	
	
}
