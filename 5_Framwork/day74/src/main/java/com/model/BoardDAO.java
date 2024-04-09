package com.model;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.model.vo.BoardVO;
import com.service.Paging;


@Repository
public class BoardDAO {
	
	@Autowired
	private JdbcTemplate jt;
	
	private RowMapper<BoardVO> rm = (ResultSet rs, int rowNum) -> {
		
		BoardVO row = new BoardVO();
		
		row.setIdx(rs.getInt("idx"));
		row.setContents(rs.getString("contents"));
		row.setTitle(rs.getString("title"));
		row.setNick(rs.getString("nick"));
		row.setV_count(rs.getInt("v_count"));
		row.setW_date(rs.getDate("w_date"));
		
		
		return row;
		
	};
	
	public int totalBoard() {
		String sql = "select count(*) as count from board";
		
		
		return jt.queryForObject(sql, Integer.class);
	}
	
	
	
	public List<BoardVO> selectAll(Paging pg) {
		
		String sql = "select * from board_view order by idx desc " +
						"offset ? rows " + 
						"fetch first ? rows only";
		
		return jt.query(sql, rm, pg.getOffset(), pg.getBoardCount());
	}


	public int write(BoardVO input) {
		String sql = "insert into board(title, user_idx, contents) " +
				"values(?, ?, ?)";

		String title = input.getTitle();
		int user_idx = input.getUser_idx();
		String contents = input.getContents();
		
		return jt.update(sql, title , user_idx , contents);
	}


	public BoardVO selectOne(int idx) {
		
		String sql = "select * from board_view where idx = ?";
		
		return jt.queryForObject(sql, rm, idx);
	}


	public int delete(int idx) {
		
		String sql = "delete from board where idx = ?";
		
		return jt.update(sql, idx);
	}


	public int update(BoardVO input) {
		
		String sql = "update board " +
						"set title = ?," +
						"contents = ? " + 
						"where idx = ?";
		
		String title = input.getTitle();
		String contents = input.getContents();
		int idx = input.getIdx();
		
		return jt.update(sql, title, contents, idx);
	}
	
	public int updateView (BoardVO bd) {
		String sql = "update board  " +
						"set v_count = v_count + 1 " +
						"where idx = ?";
		
		return jt.update(sql, bd.getIdx());
	}


	public BoardVO selectView(int idx) {
		String sql = "select * from board_view where idx = ?";
		
		BoardVO bd = new BoardVO();
		
		bd = jt.queryForObject(sql, rm, idx);
		
		updateView(bd);
		
		return bd;
	}


	
	
	
}
