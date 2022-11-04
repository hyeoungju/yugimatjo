package com.matjo.rsrs.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private UserService userService;
	public void init() {
		userService = new UserService(new UserDao());
	}
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.getRequestDispatcher("/login/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		
		if (!userService.isValidUser(userId,passwd)) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('아이디와 비밀번호가 틀렸습니다.'); location.href='"+"/rsrs/main/main.jsp"+"';</script>"); 
			writer.close();
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		HttpSession session = request.getSession(true);
		if(userService.isValidUser(userId,passwd)) {
			if(!userService.isUserPosition(userId, passwd)) {
				session.setAttribute("userId", userId);
				response.sendRedirect("/rsrs/restaurant/add_res.jsp");
				return;
			}
		}
		
		
		session.setAttribute("userId", userId);
		response.sendRedirect("/rsrs/main/main.jsp");
	}

}
