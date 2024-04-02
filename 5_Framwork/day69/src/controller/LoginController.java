package controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DAO;
import model.vo.AccountVO;
import model.vo.Mapper;
import service.HashPW;

@WebServlet("/account/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 4000L;
	
	private String path = "/WEB-INF/account/";
	
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
		rd = request.getRequestDispatcher(path + "login.jsp");
		rd.forward(request, response);
			
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String sql = "select * from account where userid = ? and userpw = ?";
		
		// session은 request로 부터 받을 수 있다.
		HttpSession session = request.getSession();
		String userid = request.getParameter("userid");
		
		String hashPw = "";
		HashPW hash = new HashPW();
		String userpw = request.getParameter("userpw");
		try {
			hashPw = hash.getHash(userpw);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("getHash예외 : " + e.getMessage());
		}

		String cpath = request.getContextPath();
		
		DAO dao = new DAO();
		AccountVO user = dao.queryForObject(sql, mp, userid, hashPw);
		
		session.setAttribute("user", user);
		
		response.sendRedirect(cpath+ "/home");
				
		
		
	}
	
}
