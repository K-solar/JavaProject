package com.model;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.model.vo.AccountVO;

@Repository
public class AccountDAO {
	
	@Autowired
	private JdbcTemplate jt;
	
	private RowMapper<AccountVO> rm = (ResultSet rs, int rowNum) -> {
		
		AccountVO row = new AccountVO();
		
		row.setIdx(rs.getInt("idx"));
		row.setUserid(rs.getString("userid"));
		row.setUserpw(rs.getString("userpw"));
		row.setNick(rs.getString("nick"));
		row.setEmail(rs.getString("email"));
		row.setJ_date(rs.getDate("j_date"));
		
		return row;
	};
	
	public String test() {
		String sql = "select banner from v$version";
		
		return jt.queryForObject(sql, String.class);
	}

	public List<AccountVO> selectAll() {
		
		String sql = "select * from account order by idx desc";
		
		return jt.query(sql, rm);
	}
	
	
	public int insert(AccountVO input) {
		String sql = "insert into account(userid, userpw, nick, email) " +
						"values(?, ?, ?, ?)";
		
		String userid = input.getUserid();
		String userpw = input.getUserpw();
		String nick = input.getNick();
		String email = input.getEmail();
		
		return jt.update(sql, userid, userpw, nick, email);
		
	}

	public int delete(int idx) {
		
		String sql = "delete from account where idx = ?";
	
		return jt.update(sql, idx);
	}

	public int update(AccountVO input) {
		String sql = "update account " +
						"set userid = ?, " +
						"userpw = ?, " +
						"nick = ?, " +
						"email = ? " +
						"where idx = ?";
		
		String userid = input.getUserid();
		String userpw = input.getUserpw();
		String nick = input.getNick();
		String email = input.getEmail();
		int idx = input.getIdx();
				
		return jt.update(sql, userid, userpw, nick, email, idx);
	}
	
}
