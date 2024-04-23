package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.itbank.model.vo.AccountVO;

public interface AccountDAO {
	
	@Select("select * from account order by idx desc")
	List<AccountVO> accinfo();
	
	AccountVO selectOne(AccountVO user);
	
	int insert(AccountVO input);

	AccountVO findAcc(AccountVO input);

	int updatePw(AccountVO pw);

	int updateAcc(AccountVO input);

	AccountVO selectAcc(int idx);

	int delAcc(int idx);
	
}
