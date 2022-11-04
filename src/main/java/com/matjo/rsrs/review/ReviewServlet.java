package com.matjo.rsrs.review;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.matjo.rsrs.restaurant.Restaurant;
import com.matjo.rsrs.restaurant.RestaurantDao;
import com.matjo.rsrs.restaurant.RestaurantService;
import com.matjo.rsrs.user.User;
import com.matjo.rsrs.user.UserDao;
import com.matjo.rsrs.user.UserService;


@WebServlet("/restaurant/review") //로그인한후
public class ReviewServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
    private UserService userService;
    private ReviewService reviewService;
    private RestaurantService restaurantService;
   
   public void init() {
      reviewService = new ReviewService(new ReviewDao());
      userService = new UserService(new UserDao());
      restaurantService = new RestaurantService(new RestaurantDao());
   }

   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      HttpSession session = request.getSession();
      // 1. 폼 파라메터 열기
      String userId = (String) session.getAttribute("userId");
      String referer = request.getHeader("referer").split("=")[1];
      System.out.println("이전: " +  referer);
      Restaurant res = restaurantService.findResToSubpage(referer);
      String reviewText = request.getParameter("reviewText");
      String recommandScore = request.getParameter("recommandScore");
      User user = userService.getUserId(userId);
      
      // 2. 유효성 검증 및 변환
      List<String> errorMsgs = new ArrayList<>();
      if(reviewText == null) {
         errorMsgs.add("리뷰내용을 입력해주세요.");
      }
      
      
      Review review = new Review();
      review.setUserId(user.getuId());
      review.setResId(res.getRid());
      review.setReviewText(reviewText);

      //3. 비즈니스 서비스 호출
      reviewService.addReview(review);
      request.setAttribute("review", review);
      
//      response.sendr
      

   }
}