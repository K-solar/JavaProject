package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.itbank.vo.AccountVO;

@Repository
public interface AccountDAO {
	
	@Select("select * from account order by idx desc")
	List<AccountVO> selectAll();
	
	
	@Select("select * from account where userid = #{userid} and userpw = #{userpw}")
	AccountVO selectOne(AccountVO input);

	
	@Insert("insert into account (userid, userpw, nick) values (#{userid}, #{userpw}, #{nick})")
	int insertAcc(AccountVO input);

	@Delete("delete account where idx = #{idx}")
	int deleteAcc(int idx);

	@Update("update account set userpw = #{userpw} where idx = #{idx}")
	int update(AccountVO input);

}
