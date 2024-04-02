package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.vo.BoardVO;
import model.vo.Mapper;

@WebServlet("/selectboard")
public class SelectBoardController extends HttpServlet {

	private static final long serialVersionUID = 400L;
	
	
	private Mapper<BoardVO> mp = (ResultSet rs) -> {
		
		BoardVO row = new BoardVO();
		row.setIdx(rs.getInt("idx"));
		row.setTitle(rs.getString("title"));
		row.setContents(rs.getString("contents"));
		row.setNick(rs.getString("nick"));
		row.setV_count(rs.getInt("v_count"));
		row.setW_date(rs.getDate("w_date"));
		
		return row;
		
	};
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		DAO dao = new DAO();
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		String sql = "update board set v_count = v_count + 1 " +
						"where idx = ?";
		
		
		
		dao.update(sql, idx);
		
		
		String sql2 = "select * from board_view " +
						"where idx = ?";
		
		
		BoardVO bv = dao.queryForObject(sql2, mp, idx);		
		
		request.setAttribute("boardlist", bv);

		
		
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/WEB-INF/selectboard.jsp");
		rd.forward(request, response);
		
		
	}
	
}
