package com.itbank.service;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

@Service
public class TestService {

	public int total(int n) {
		int sum = 0;
		
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		
		return sum;
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
