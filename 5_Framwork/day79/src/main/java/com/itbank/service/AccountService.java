package com.itbank.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.components.HashPw;
import com.itbank.components.NewPw;
import com.itbank.model.AccountDAO;
import com.itbank.model.vo.AccountVO;

@Service
public class AccountService  {
	
	@Autowired
	private AccountDAO dao;
	
	@Autowired
	HashPw hp;
	
	@Autowired
	NewPw np;
	
	
	public List<AccountVO> getAcc() {
		return dao.accinfo();
	}
	
	public AccountVO login(AccountVO user) {
		String hashPw = "";
		
		try {
			hashPw = hp.getHash(user.getUserpw());
		} catch (NoSuchAlgorithmException e) {
			System.out.println("getHash 예외 :  " + e.getMessage());
		}
		user.setUserpw(hashPw);
		
		return dao.selectOne(user);
	}
	
	public int addAccount(AccountVO input) {
		String hashPw = "";
		
		try {
			hashPw = hp.getHash(input.getUserpw());
			input.setUserpw(hashPw);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("getHash 예외 :  " + e.getMessage());
		}
		
		
		return dao.insert(input);
	}

	public String resetPw(AccountVO input) {
		String newPw = "";
		String hashPw = "";
		AccountVO pw = dao.findAcc(input);
		
		newPw = np.getPw();
		try {
			hashPw = hp.getHash(newPw);
			pw.setUserpw(hashPw);
			dao.updatePw(pw);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("getHash예외 : " + e.getMessage());
		}
		
		
		
		
		return newPw;
	}

	public AccountVO findAcc(AccountVO input) {
		
		return dao.findAcc(input);
	}
	
	
	
	public int update(AccountVO input) {
		
		AccountVO acc = dao.selectAcc(input.getIdx());
		int row = dao.updateAcc(input);
		String upPw = "";
		
		if (row == 1) {
			try {
				upPw = hp.getHash(input.getUserpw());
			} catch (NoSuchAlgorithmException e) {
				System.out.println("getHash 예외 : " + e.getMessage());
			}
		}
		acc.setUserpw(upPw);

		dao.updatePw(acc);
		
		return row;
	}

	public AccountVO selectAcc(int idx) {
		return dao.selectAcc(idx);
	}

	public int delAcc(int idx) {
		return dao.delAcc(idx);
	}
	
}
