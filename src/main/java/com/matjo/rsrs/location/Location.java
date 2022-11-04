package com.matjo.rsrs.location;

public class Location {
	private String regionName;
	private long resid;
	
	public Location(String regionName) {
		this.regionName = regionName;
	}
	
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	public long getResid() {
		return resid;
	}
	public void setResid(long resid) {
		this.resid = resid;
	}
	
	
}
