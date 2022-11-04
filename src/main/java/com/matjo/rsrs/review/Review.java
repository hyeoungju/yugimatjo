package com.matjo.rsrs.review;

import java.util.Date;

public class Review {
	private long reviewId;
	private long userId;
	private long resId;
	private String reviewText;
	private Date regDate;
	private int recommandScore;
	public long getReviewId() {
		return reviewId;
	}
	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getResId() {
		return resId;
	}
	public void setResId(long resId) {
		this.resId = resId;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getRecommandScore() {
		return recommandScore;
	}
	public void setRecommandScore(int recommandScore) {
		this.recommandScore = recommandScore;
	}
	
	
	
}
