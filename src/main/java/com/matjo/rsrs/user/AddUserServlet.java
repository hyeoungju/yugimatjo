package com.matjo.rsrs.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join/add_user.do")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private UserService userService;  

     public void init() {
    	 userService = new UserService(new UserDao());
     }
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		String userName = request.getParameter("userName");
		String userId = request.getParameter("userId");
		String passwd = request.getParameter("passwd");
		String nickname = request.getParameter("nickname");
		
		
		List<String>errorMsgs = new ArrayList<>();
		if (userName == null || userName.length() == 0) {
			errorMsgs.add("이름은 필수입력 정보이다.");
		}
		if (userId == null || userId.length() == 0) {
			errorMsgs.add("아이디는 필수입력 정보이다.");
		}
		if (passwd == null || passwd.length() == 0) {
			errorMsgs.add("비밀번호는 필수입력 정보이다.");
		}
		if (nickname == null || nickname.length() == 0) {
			errorMsgs.add("닉네임은 필수입력 정보이다.");
		}
		
		RequestDispatcher dispatcher = null;
		if (errorMsgs.size() > 0) {
			request.setAttribute("오류", errorMsgs);
			dispatcher = request.getRequestDispatcher("/error/add_user_error.jsp");
			dispatcher.forward(request, response);
			return;
		}
		User user = new User();
		user.setUserName(userName);
		user.setUserId(userId);
		user.setPasswd(passwd);
		user.setNickname(nickname);
		
		userService.addUser(user);
		request.setAttribute("user", user);
		
		request.setAttribute("userName", userName);
		dispatcher = request.getRequestDispatcher("/success/add_user_success.jsp");
		dispatcher.forward(request, response);
	}

}
