package controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import service.HashPW;

@WebServlet("/account/signUp")
public class SingupController extends HttpServlet {

	private static final long serialVersionUID = 7000L;

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/WEB-INF/account/signUp.jsp");
		rd.forward(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String sql = "insert into account (userid, userpw, nick, email) " +
						"values(?, ?, ?, ?)";
		
		String cpath = request.getContextPath();
		
		String userid = request.getParameter("userid");
		
		String hashPw = "";
		HashPW hash = new HashPW();
		String userpw = request.getParameter("userpw");
		try {
			hashPw = hash.getHash(userpw);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("getHash예외 : " + e.getMessage());
		}
		
		
		
		String nick = request.getParameter("nick");
		String email = request.getParameter("email");

		
		DAO dao = new DAO();
		int row = dao.signUp(sql, userid, hashPw, nick, email);
		
		if (row != 0) {
			response.sendRedirect(cpath);	
		}
		
	}

}
