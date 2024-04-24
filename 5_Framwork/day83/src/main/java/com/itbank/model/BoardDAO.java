package com.itbank.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.itbank.model.vo.BoardVO;

public interface BoardDAO {
	
	@Select("select * from board order by idx desc")
	List<BoardVO> selectAll();
	
	@Insert("insert into board(nick) values(#{nick})")
	void insert(String nick);
	
	@Insert("insert into board(title, nick, contents) values(#{title}, #{nick}, #{contents})")
	int writeBoard(BoardVO input);

	@Select("select * from board where idx = #{idx}")
	BoardVO selectOne(int idx);

	@Delete("delete from board where idx = #{idx}")
	int delboard(int idx);
	
	@Update("update board set title = #{title}, nick = #{nick}, contents = #{contents} where idx = #{idx}")
	int updateBd(BoardVO input);
	
}
