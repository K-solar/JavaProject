package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.StudentVO;


public class StudentDAO extends DAO {
	
	public List<StudentVO> selectAll() {
		String sql = "select * from student order by idx desc";
		
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			List<StudentVO> list = new ArrayList<>();
			
			while (rs.next()) {
				StudentVO row = new StudentVO();
				
				row.setIdx(rs.getInt("idx"));
				row.setName(rs.getString("name"));
				row.setKor(rs.getInt("kor"));
				row.setEng(rs.getInt("eng"));
				row.setMat(rs.getInt("mat"));
				
				list.add(row);
				
				
			}
			
			return list;
			
		} catch (SQLException e) {
			System.out.println("selectAll 예외 : " + e.getMessage());
		}
		
		return null;
	}
	
	public StudentVO selectOne (int idx) {
		
		String sql = "select * from student " +
						"where idx = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, idx);

			rs = pstmt.executeQuery();
			rs.next();
			
			StudentVO row = new StudentVO();
			
			row.setIdx(rs.getInt("idx"));
			row.setName(rs.getString("name"));
			row.setKor(rs.getInt("kor"));
			row.setEng(rs.getInt("eng"));
			row.setMat(rs.getInt("mat"));
			
			return row;
			
		} catch (SQLException e) {
			System.out.println("selectOne 예외  : " + e.getMessage());
		} finally {
			close();
		}
		
		
		return null;
	}
	
	
	public int insert(StudentVO sv) {
		
		String sql = "insert into student(name, kor, eng, mat) " +
						"values(?, ?, ?, ?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, sv.getName());
			pstmt.setInt(2, sv.getKor());
			pstmt.setInt(3, sv.getEng());
			pstmt.setInt(4, sv.getMat());
			
			int row = pstmt.executeUpdate();
			
			return row;
			
			
		} catch (SQLException e) {
			System.out.println("insert 예외 : " + e.getMessage());
		}	finally {
			close();
		}
		
		return 0;	
	}
	
	
	public int delete(int idx) {
		String sql = "delete from student where idx = ?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("delete 예외 : " + e.getMessage());
		
		} finally {
			close();
		}
		
		return 0;
	} 
	
	
	public int update(StudentVO cv, int idx) {
		
		String sql = "update student " + 
				"set " +
						"name = ?, " +
						"kor = ?, " + 
						"eng = ?, " +
						"mat = ? " +
						"where idx = ?";
		
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cv.getName());
			pstmt.setInt(2, cv.getKor());
			pstmt.setInt(3, cv.getEng());
			pstmt.setInt(4, cv.getMat());
			pstmt.setInt(5, idx);
			
			return pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			System.out.println("update 예외 : " + e.getMessage());
		} finally {
			close();
		}
		
		return 0;
	}
	
}
