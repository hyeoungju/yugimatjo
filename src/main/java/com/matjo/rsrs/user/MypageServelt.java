package com.matjo.rsrs.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login/userInformation")
public class MypageServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService;
	
	public void init() {
		userService = new UserService(new UserDao());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		String passwd = request.getParameter("passwd");
		
		if (!userService.isValidUser((String)session.getAttribute("userId"), passwd)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('비밀번호가 틀렸습니다.'); location.href='"+"/rsrs/main/main.jsp"+"';</script>"); 
			writer.close();
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		UserService uService = new UserService();
		String userId = (String) session.getAttribute("userId");
		String grade = uService.getGrade(userId);
		
		request.getRequestDispatcher("userInformation.jsp").forward(request, response);
	}
	

}
