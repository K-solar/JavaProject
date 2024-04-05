package com.service;

import org.springframework.stereotype.Service;

import com.model.vo.AccountVO;

@Service
public class QuizService {

	public String login(AccountVO input) {
		
		AccountVO [] users = new AccountVO [] {
				new AccountVO ("soopi", "50091", "수피"),
				new AccountVO ("winter", "010101", "윈터"),
				new AccountVO ("itbank", "it", "아뱅"),
				new AccountVO ("root", "1", "관리자")
		};
		
		String msg = "로그인 실패";
		
		for (int i = 0; i < users.length; i++) {
			if (users[i].equals(input)) {
				msg = users[i].getNick() + "님 로그인 성공~^^";
				break;
			}
		}
		
		
		return msg;
		
	}

}
