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

@WebServlet("/account")
public class UserListController extends HttpServlet {

	private static final long serialVersionUID = 2000L;

	
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
		String sql = "select * from account order by idx desc";
		
		DAO dao = new DAO();
		
		request.setAttribute("list", dao.query(sql, mp));
		
		RequestDispatcher rd;
		
		rd = request.getRequestDispatcher("/WEB-INF/account/userList.jsp");
		rd.forward(request, response);
		
		
		
	}
}
