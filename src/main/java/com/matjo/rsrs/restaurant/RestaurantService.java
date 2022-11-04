package com.matjo.rsrs.restaurant;

import java.util.List;

import com.matjo.rsrs.location.Location;
import com.matjo.rsrs.review.Review;

public class RestaurantService {
	private RestaurantDao restaurantDao;
	
	public RestaurantService(RestaurantDao restaurantDao) {
		this.restaurantDao = restaurantDao;
	}
	
	public void addRes(Restaurant restaurant, Location location) {
		restaurantDao.addRes(restaurant, location);	
	}
	
	public List<Restaurant> findResByCondition(String resLocation, String foodType, int foodPrice, int resCapacity) {
		return restaurantDao.findResByCondition(resLocation, foodType, foodPrice, resCapacity);
	}
	
	public Restaurant findResToSubpage(String resName){
		return restaurantDao.findResToSubpage(resName);
	}
	
	public List<Review> getAllReview(long rid) {
		return restaurantDao.getAllReview(rid);
	}
}
