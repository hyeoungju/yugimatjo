package com.matjo.rsrs.restaurant;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.matjo.rsrs.review.Review;

/**
 * Servlet implementation class ViewSubPage
 */
@WebServlet("/restaurant/subpage")
public class ViewSubPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private RestaurantService restaurantService;

	@Override
	public void init() throws ServletException {
		restaurantService = new RestaurantService(new RestaurantDao());
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resName = request.getParameter("resName");
		
		List<Review> list = null;
		Restaurant s = null;
		
		s = restaurantService.findResToSubpage(resName);
		list = restaurantService.getAllReview(s.getRid());
		for(Review rv : list) {
			System.out.println(rv.toString());
		}
		
		request.setAttribute("restaurant", s);
		request.setAttribute("reviewList", list);
		request.setAttribute("resName", resName);
			
		RequestDispatcher rd = request.getRequestDispatcher("/restaurant/subpage.jsp");
		rd.forward(request, response);
	}	
}
