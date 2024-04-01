package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;

@WebServlet("/board")
public class BoardController extends HttpServlet {

	private static final long serialVersionUID = 3000L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/WEB-INF/write.jsp");
		rd.forward(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		int user_idx = Integer.parseInt(request.getParameter("user_idx"));
		
		String sql =  "insert into " +
						"board(title, contents, user_idx) " + 
						"values(?, ?, ?)";
		
		DAO dao = new DAO();
		
		// 디버그
		int row = dao.update(sql, title, contents, user_idx);
		
		System.out.println(row == 0 ? "실패" : "성공");
		
		String cpath = request.getContextPath();
		response.sendRedirect(cpath);
		
	}
	
}
