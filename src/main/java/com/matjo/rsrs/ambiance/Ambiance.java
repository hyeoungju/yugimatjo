package com.matjo.rsrs.ambiance;

public class Ambiance {
	private int comfort;
	private int luxury;
	private int cost;
	private int dating;
	private int family;
	private int comfortScroe;
	private int luxuryScore;
	private int costScore;
	private int datingScore;
	private int familyScore;
	
	private double comfortAvgScore;
	private double luxuryAvgScore;
	private double costAvgScore;
	private double datingAvgScore;
	private double familyAvgScore;
	
	public Ambiance(double comfortAvgScore, double luxuryAvgScore, double costAvgScore, double datingAvgScore, double familyAvgScore) {
		this.comfortAvgScore = comfortAvgScore;
		this.luxuryAvgScore = luxuryAvgScore;
		this.costAvgScore = costAvgScore;
		this.datingAvgScore = datingAvgScore;
		this.familyAvgScore = familyAvgScore;
	}
	
	
	public int getComfort() {
		return comfort;
	}
	public void setComfort(int comfort) {
		this.comfort = comfort;
	}
	public int getLuxury() {
		return luxury;
	}
	public void setLuxury(int luxury) {
		this.luxury = luxury;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getDating() {
		return dating;
	}
	public void setDating(int dating) {
		this.dating = dating;
	}
	public int getFamily() {
		return family;
	}
	public void setFamily(int family) {
		this.family = family;
	}
	public int getComfortScroe() {
		return comfortScroe;
	}
	public void setComfortScroe(int comfortScroe) {
		this.comfortScroe = comfortScroe;
	}
	public int getLuxuryScore() {
		return luxuryScore;
	}
	public void setLuxuryScore(int luxuryScore) {
		this.luxuryScore = luxuryScore;
	}
	public int getCostScore() {
		return costScore;
	}
	public void setCostScore(int costScore) {
		this.costScore = costScore;
	}
	public int getDatingScore() {
		return datingScore;
	}
	public void setDatingScore(int datingScore) {
		this.datingScore = datingScore;
	}
	public int getFamilyScore() {
		return familyScore;
	}
	public void setFamilyScore(int familyScore) {
		this.familyScore = familyScore;
	}
	
	
	
}
