package com.matjo.rsrs.review;

import java.util.List;

public class ReviewService {
//	private static ReviewService service = new ReviewService();// 싱글톤
	public ReviewDao reviewDao;

	public ReviewService(ReviewDao reviewDao) {
		this.reviewDao = reviewDao;
	}

	public ReviewService() {

	}

	public void addReview(Review review) {
		reviewDao.addReview(review);
	}
	
	public void updateAccount(Review review) {
		reviewDao.updateAccount(review);
	}

//	public List<User> findUser() {
//		return userDao.findAllUsers();
//	}
//
//	public static ReviewService getInstance() {
//		return service;
//	}
//
//	public void setUserDao(UserDao userDao) {
//		this.userDao = userDao;
//	}

}
