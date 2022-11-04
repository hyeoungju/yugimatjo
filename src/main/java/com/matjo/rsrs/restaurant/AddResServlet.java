package com.matjo.rsrs.restaurant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matjo.rsrs.location.Location;


/**
 * Servlet implementation class AddResServlet
 */
@WebServlet("/restaurant/add_res.do")
public class AddResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RestaurantService restaurantService;

	
	@Override
		public void init() throws ServletException {
			restaurantService = new RestaurantService(new RestaurantDao());
		}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String resName = request.getParameter("resName");
		String resLocation1= request.getParameter("resLocation1");
		String resLocation2= request.getParameter("resLocation2");
		String resScore = request.getParameter("resScore");
		String foodType = request.getParameter("foodType");
		String foodPrice = request.getParameter("foodPrice");
		String resCapacity = request.getParameter("resCapacity");
		
		//2. 유효성 검증 및 변환
		List<String> errorMsgs = new ArrayList();
		if(resName == null || resName.length() == 0) {
			errorMsgs.add("가게이름은 필수입력 정보입니다.");
		}
		
		RequestDispatcher dispatcher = null;
		if(errorMsgs.size() > 0) {
			request.setAttribute("errorMsgs", errorMsgs);
			dispatcher = request.getRequestDispatcher("/error/add_res_error.jsp");
			dispatcher.forward(request, response);
			return;
		}
		Restaurant restaurant = new Restaurant();
		Location location = new Location(resLocation1 + " " + resLocation2);
		restaurant.setResName(resName);
		restaurant.setResScore(Double.parseDouble(resScore));
		restaurant.setFoodType(foodType);
		restaurant.setFoodPrice(Integer.parseInt(foodPrice));
		restaurant.setResCapacity(Integer.parseInt(resCapacity));
		
		//3. 비즈니스 서비스 호출
		restaurantService.addRes(restaurant, location);
		request.setAttribute("restaurant", restaurant);
		
		//4. NextPage
		request.setAttribute("resName", resName);
		dispatcher = request.getRequestDispatcher("/success/add_res_success.jsp");
		dispatcher.forward(request, response);
		
	}

}
