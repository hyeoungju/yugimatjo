package com.matjo.rsrs.restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.matjo.rsrs.ambiance.Ambiance;
import com.matjo.rsrs.data.DataSource;
import com.matjo.rsrs.data.NamingService;
import com.matjo.rsrs.location.Location;
import com.matjo.rsrs.review.Review;

public class RestaurantDao {
	private DataSource dataSource;
	
	public RestaurantDao() {
		NamingService namingService = NamingService.getInstance();
		dataSource = (DataSource)namingService.getAttribute("dataSource");
	}
	public void addRes(Restaurant res, Location location) {
		String sql = "INSERT INTO Restaurant(resName, resScore, "
				+ " foodType, foodPrice, resCapacity) "
				+ " VALUES (?, ?, ?, ?, ?)";
		String sql2 = "INSERT INTO Location(regionName, resId) VALUES (?, ?)";
		String sql3 = "INSERT INTO Ambiance(resId) VALUES(?)";
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, res.getResName());
				pstmt.setDouble(2, res.getResScore());
				pstmt.setString(3, res.getFoodType());
				pstmt.setInt(4, res.getFoodPrice());
				pstmt.setInt(5, res.getResCapacity());
				pstmt.execute();
				System.out.println("RESTAURNAT INSERTED...");
				Restaurant res2 = getResId(res.getResName());
				pstmt = con.prepareStatement(sql2);
				pstmt.setString(1, location.getRegionName());
				pstmt.setLong(2, res2.getRid());
				pstmt.execute();
				System.out.println("LOCATION INSERTED...");
				pstmt = con.prepareStatement(sql3);
				pstmt.setLong(1, res2.getRid());
				pstmt.execute();
				System.out.println("AMBIANCE INSERTED...");
			} finally {
				dataSource.close(pstmt, con);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Restaurant getResId(String resName) {
		String sql = "SELECT rId FROM Restaurant WHERE resName=?";
		long rid = 0;
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, resName);
				rs = pstmt.executeQuery();
				Restaurant res = null;
				while(rs.next()) {
					res = new Restaurant();
					res.setRid(rs.getLong("rId"));
					return res;
				}
				
			} finally {
				dataSource.close(rs, pstmt, con);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		return null;
	}
	
	
	
	public List<Restaurant> findResByCondition(String resLocation, String foodType, 
							int foodPrice, int resCapacity) {
		String sql = "Select r.*, lo.regionName, ab.comfort / ab.comfortScore as '편안한', ab.luxury / ab.luxuryScore as '럭셔리한', "
				+ "ab.cost / ab.costScore as '가성비', ab.dating / ab.datingScore as '데이트하기좋은', ab.family / ab.familyScore as '가족' FROM Restaurant r "
				+ "INNER JOIN Ambiance ab ON r.rId = ab.resId INNER JOIN Location "
				+ "lo ON r.rId = lo.resId WHERE lo.regionName=? AND r.foodType=? "
				+ "AND r.foodPrice BETWEEN 0 AND ? AND r.resCapacity BETWEEN 1 AND ?";
		List<Restaurant> list = new ArrayList<>();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, resLocation);
				pstmt.setString(2, foodType);
				pstmt.setInt(3, foodPrice);
				pstmt.setInt(4, resCapacity);
				rs = pstmt.executeQuery();
				Restaurant res = null;
				while(rs.next()) {
					res = new Restaurant();
					res.setRid(rs.getLong("rId"));
					res.setResName(rs.getString("resName"));
					res.setResScore(rs.getDouble("resScore"));
					res.setFoodType(rs.getString("foodType"));
					res.setFoodPrice(rs.getInt("foodPrice"));
					res.setResCapacity(rs.getInt("resCapacity"));
					res.setAmbiance(new Ambiance(rs.getDouble("편안한"), rs.getDouble("럭셔리한"),
							rs.getDouble("가성비"), rs.getDouble("데이트하기좋은"), rs.getDouble("가족")));
					list.add(res);
				}
			} finally {
				dataSource.close(rs, pstmt, con);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Restaurant findResToSubpage(String resName) {
			String sql = "SELECT * FROM Restaurant WHERE resName=?";
			try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, resName);
			rs = pstmt.executeQuery();
			Restaurant res = null;
			while(rs.next()) {
				res = new Restaurant();
				res.setRid(rs.getLong("rId"));
				res.setResName(rs.getString("resName"));
				res.setResScore(rs.getDouble("resScore"));
				res.setFoodType(rs.getString("foodType"));
				res.setFoodPrice(rs.getInt("foodPrice"));
				res.setResCapacity(rs.getInt("resCapacity"));
				return res;
			}
			} finally {
			dataSource.close(rs, pstmt, con);
			}
			
			} catch (SQLException e) {
			e.printStackTrace();
			}
			return null;
	}
	public List<Review> getAllReview(long rid) {
		String sql = "SELECT * FROM Review rv INNER JOIN Restaurant res ON rv.resId = res.rid WHERE res.rid=?";
		List<Review> list = new ArrayList<Review>();
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, rid);
			rs = pstmt.executeQuery();
			Review review = null;
			while(rs.next()) {
				review = new Review();
				review.setReviewId(rs.getLong("reviewId"));
				review.setUserId(rs.getLong("userId"));
				review.setResId(rs.getLong("resId"));
				review.setReviewText(rs.getString("reviewText"));
				list.add(review);
			}
			} finally {
			dataSource.close(rs, pstmt, con);
			}
			
			} catch (SQLException e) {
			e.printStackTrace();
			}
			return list;
	}
	
}
