package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.vo.BoardVO;
import model.vo.Mapper;
import service.Paging;

@WebServlet("/board")
public class Board extends HttpServlet {

	private static final long serialVersionUID = 1000L;
	
	private Mapper<BoardVO> mp = (ResultSet rs) -> {
		BoardVO row = new BoardVO();
		
		row.setContents(rs.getString("contents"));
		row.setIdx(rs.getInt("idx"));
		row.setNick(rs.getString("nick"));
		row.setTitle(rs.getString("title"));
		row.setV_count(rs.getInt("v_count"));
		row.setW_date(rs.getDate("w_date"));
		
		return row;
		
	};
	
	private Mapper<Integer> bmp = (ResultSet rs) -> {
		int boardCount = rs.getInt("total");
		
		return boardCount;
	};
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// 1. 사용자가 요청한 페이지 번호
		String reqPage = request.getParameter("reqPage");
		int rp = 1;
		if (reqPage != null) {
			rp = Integer.parseInt(reqPage);
		}
		
		// 2. board테이블 전체 게시글 수
		
		DAO dao = new DAO();
		
		String bcnt = "select count(*) as total from board"; 
		List<Integer> boardCount = dao.query(bcnt, bmp);
		
		int bc = boardCount.get(0);
		int count = dao.totalBoard();
		
		// 3. 1 ~ 2 번 값으로 페이징 진행
		Paging pg = new Paging(rp, bc);
		String sql = "select * from board_view " + 
				"order by idx desc " + 
				"offset ? rows " + 
				"fetch first ? rows only";
		
		
		
		// 4. 테이블(list)와 페이징(pg)을 지정 jsp로 전달
		request.setAttribute("list", dao.query(sql, mp, pg.getOffset(), pg.getBoardCount()));
		request.setAttribute("pg",pg);
		request.setAttribute("count", count);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/WEB-INF/board.jsp");
		rd.forward(request, response);
	}
	
	

}