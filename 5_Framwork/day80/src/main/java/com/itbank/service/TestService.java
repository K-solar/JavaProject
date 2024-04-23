package com.itbank.service;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	public void firstAOP() {
		System.out.println("service 메서드 호출~");
		
	}
	
	
	
	public Set<Integer> lotto() {
		
		Random rd = new Random();
		TreeSet<Integer> lotto = new TreeSet<>();
		
		while (lotto.size() != 6) {
			lotto.add(rd.nextInt(45) + 1);
		}
		return lotto;
	}

}
