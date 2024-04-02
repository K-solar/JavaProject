package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/account/logout")
public class LogoutController extends HttpServlet {

	private static final long serialVersionUID = 5000L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String cpath = request.getContextPath();
		
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		
		response.sendRedirect(cpath);
		
		
		
	}
	
}
