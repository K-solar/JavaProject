package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itbank.model.AccountDAO;
import com.itbank.vo.AccountVO;

@Service
public class AccountService {

	@Autowired
	private AccountDAO dao;
	
	public List<AccountVO> getAccount() {
		
		return dao.selectAll();
	}


	public AccountVO login(AccountVO input) {
				
		return dao.selectOne(input);
	}

	@Transactional(rollbackFor = Exception.class)
	public int addAcc(AccountVO input) {
		
		return dao.insertAcc(input);
	}


	public int delAcc(int idx) {
		
		return dao.deleteAcc(idx);
	}


	public int updateAcc(AccountVO input) {
		
		return dao.update(input);
		
	}

}
