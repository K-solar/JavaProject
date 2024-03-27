package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Quiz1")
public class Quiz1 extends HttpServlet {

	private static final long serialVersionUID = 5L;
		
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/WEB-INF/quiz1.jsp");
		
		rd.forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String adult = "성인";
		
		if (age <= 19) { adult = "미성년자"; }
		
		String result = name + "은 " + age + "세 이므로 " + adult + "입니다.";
		
		request.setAttribute("result", result);
		
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/WEB-INF/quiz1_result.jsp");
		
		rd.forward(request, response);
		
	}
}
