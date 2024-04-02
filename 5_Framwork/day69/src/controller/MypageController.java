package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;

@WebServlet("/account/myPage")
public class MypageController extends HttpServlet {

	private static final long serialVersionUID = 6000L;
	
	private String path = "/WEB-INF/account/";
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher(path + "myPage.jsp");
		rd.forward(request, response);
			
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		String sql  = "update account " +
						"set userpw = ?, " +
							"nick = ?, " +
							"email = ? " +
							"where idx = ?";
		
		String userpw = request.getParameter("userpw");
		String nick = request.getParameter("nick");
		String email = request.getParameter("email");

		
		DAO dao = new DAO();
		int row = dao.update(sql, userpw, nick, email, idx);
		
		String cpath = request.getContextPath();
		
		if (row != 0) {
			response.sendRedirect(cpath);	
		}

		
	}
}
