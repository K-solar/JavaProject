package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itbank.vo.AccountVO;

public interface AccountDAO {
	
	@Select("select * from account order by idx desc")
	List<AccountVO> selectAll();
	
	@Select("select * from account where userid = #{userid} and userpw = #{userpw}")
	AccountVO selectOne(AccountVO input);
	
	@Insert("insert into account(userid, userpw, nick, email) values(#{userid}, #{userpw}, #{nick}, #{email})")
	int insert(AccountVO input);
	
	@Update("update account set userpw = #{userpw} where idx = #{idx}")
	int update(AccountVO input);
	
	@Delete("delete from account where idx = #{idx}")
	int delete(int idx);
	
	@Select("select count(*) from account where userid = #{userid}")
	int selectId(String userid);
	
	
}
