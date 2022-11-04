package com.matjo.rsrs.restaurant;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matjo.rsrs.location.Location;

/**
 * Servlet implementation class SearchResServelt
 */
@WebServlet("/main/search_result.do")
public class SearchResServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RestaurantService restaurantService;
	private List<Restaurant> list;

	
	@Override
	public void init() throws ServletException {
		restaurantService = new RestaurantService(new RestaurantDao());
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String resLocation1= request.getParameter("resLocation1");
		String resLocation2= request.getParameter("resLocation2");
		String foodType = request.getParameter("foodType");
		String foodPrice = request.getParameter("foodPrice");
		String resCapacity = request.getParameter("resCapacity");
		
		foodPrice = subStringCost(foodPrice);
		resCapacity = resCapacity.split("인")[0];
		
		RequestDispatcher dispatcher = null;
		list = restaurantService.findResByCondition(resLocation1 + " " + resLocation2, foodType, Integer.parseInt(foodPrice), Integer.parseInt(resCapacity));
		if (list.size() == 0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>alert('검색하신 결과가 없습니다.'); location.href='"+"/rsrs/main/main.jsp"+"';</script>"); 
			writer.close();
		}
		
		
		request.setAttribute("rList", list);
		dispatcher = request.getRequestDispatcher("/restaurant/result.jsp");
		dispatcher.forward(request, response);
		
	}

	public String subStringCost(String foodPrice) {
		String[] result = foodPrice.split(" ");
		String realResult = "";
		if(result.length <= 2) {
			realResult = result[0].split("원")[0];
			return realResult.replace(",", "");
		}
		realResult = result[2].split("원")[0];	
		
		realResult = realResult.replace(",", "");
		System.out.println(realResult);
		
		return realResult;
	}
	
}