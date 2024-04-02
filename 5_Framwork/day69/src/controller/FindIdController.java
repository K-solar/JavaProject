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
import model.vo.AccountVO;
import model.vo.Mapper;

@WebServlet("/account/findId")
public class FindIdController extends HttpServlet {

	private static final long serialVersionUID = 8000L;
	
	
	private Mapper<AccountVO> mp = (ResultSet rs) -> {
		
		AccountVO row = new AccountVO();
		row.setIdx(rs.getInt("idx"));
		row.setEmail(rs.getString("email"));
		row.setJ_date(rs.getDate("j_date"));
		row.setNick(rs.getString("nick"));
		row.setUserid(rs.getString("userid"));
		row.setUserpw(rs.getString("userpw"));
		
		return row;
		
	};
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/WEB-INF/account/findId.jsp");
		rd.forward(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String sql = "select * from account " + 
						"where email = ?";
		
		String email = request.getParameter("email");
		
		DAO dao = new DAO();
		AccountVO id = dao.queryForObject(sql, mp, email);
		
		request.setAttribute("id", id.getUserid());
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/WEB-INF/account/findMsg.jsp");
		rd.forward(request, response);
		
		
	}
}
