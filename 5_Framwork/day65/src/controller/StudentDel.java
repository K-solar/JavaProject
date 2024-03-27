package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.StudentDAO;

@WebServlet("/student/delete")
public class StudentDel extends HttpServlet {

	private static final long serialVersionUID = -400L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		StudentDAO dao = new StudentDAO();
		
		int row = dao.delete(idx);
		
		String msg = (row == 0) ? "삭제 실패!" : "삭제 성공";
		
		System.out.println(msg);
		
		response.sendRedirect("/day65/student");
	}
	
}
