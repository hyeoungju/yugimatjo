package com.matjo.rsrs.restaurant;

import com.matjo.rsrs.ambiance.Ambiance;
import com.matjo.rsrs.location.Location;

public class Restaurant {
	private long rid;
	private String resName;
	private double resScore;
	private String foodType;
	private int foodPrice;
	private int resCapacity;
	private Ambiance ambiance;
	private Location location;
	
	public long getRid() {
		return rid;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public void setRid(long rid) {
		this.rid = rid;
	}
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	public double getResScore() {
		return resScore;
	}
	public void setResScore(double resScore) {
		this.resScore = resScore;
	}
	public String getFoodType() {
		return foodType;
	}
	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}
	public int getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}
	public int getResCapacity() {
		return resCapacity;
	}
	public void setResCapacity(int resCapacity) {
		this.resCapacity = resCapacity;
	}

	public Ambiance getAmbiance() {
		return ambiance;
	}
	public void setAmbiance(Ambiance ambiance) {
		this.ambiance = ambiance;
	}
	
//	@Override
//	public String toString() {
//		return getResName() + "\t평점: " + getResScore() + "\t음식: " + getFoodType() + "\t예상가격: " + getFoodPrice() + "\t기준인원: " + getResCapacity();
//	}
	
	 
}
