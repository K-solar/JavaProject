package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class Ex01 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	// GET으로 /home으로 요청 시 아래 메서드가 수행된다.
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// System.out.println("/home으로 요청했습니다!!!");
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/WEB-INF/ex01.jsp");
		
		rd.forward(request, response);
		
	}
	
	
	
}
