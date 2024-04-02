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

import model.DAO;
import model.vo.AccountVO;
import model.vo.Mapper;
import service.HashPW;
import service.NewPw;

@WebServlet("/account/findPw")
public class FindPwController extends HttpServlet {

	private static final long serialVersionUID = 9000L;
	
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
		rd = request.getRequestDispatcher("/WEB-INF/account/findPw.jsp");
		rd.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String sql = "select * from account " +
				"where userid = ? and " +
				"email = ?";
		
		String userid = request.getParameter("userid");
		String email = request.getParameter("email");
		
		DAO dao = new DAO();
		AccountVO pw = dao.queryForObject(sql, mp, userid, email);
		String newPw = "";
		
		if (pw != null) {
			try {
				NewPw np = new NewPw(); 
				newPw = np.getPw();
				HashPW hs = new HashPW();
				String hashPw;
				hashPw = hs.getHash(newPw);
				pw.setUserpw(hashPw);
				
				String sql2 = "update account " +
							"set userpw = ? " +
							"where idx = ?";
				
				dao.update(sql2, pw.getUserpw(), pw.getIdx());
				
			} catch (NoSuchAlgorithmException e) {
				System.out.println("getHash 예외 : " + e.getMessage());
			}
			
		}
		
		
		
		request.setAttribute("pw", newPw);
		
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/WEB-INF/account/findMsg.jsp");
		rd.forward(request, response);
	}
	
}
