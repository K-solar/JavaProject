package com.itbank.aop;

import java.security.NoSuchAlgorithmException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itbank.components.HashPw;
import com.itbank.model.vo.AccountVO;

@Component
@Aspect
public class AccountAOP {
	
	@Autowired
	HashPw hp;
	
	@Before("execution(int com.itbank.service.AccountService.*(com.itbank.model.vo.AccountVO))")
	public AccountVO transHash(JoinPoint jp) {
		String hashPw = "";
		AccountVO acc = (AccountVO) jp.getArgs()[0];
		
		
		try {
			hashPw = hp.getHash(acc.getUserpw());
			acc.setUserpw(hashPw);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("getHash 예외 : " + e.getMessage());
		}
		return acc;
	}
}
