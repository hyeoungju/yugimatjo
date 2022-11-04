package com.matjo.rsrs.review;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.matjo.rsrs.data.DataSource;
import com.matjo.rsrs.data.NamingService;

public class ReviewDao {
	private DataSource dataSource;
	public ReviewDao() {
		NamingService namingService = NamingService.getInstance();
		dataSource =(DataSource) namingService.getAttribute("dataSource");
	}
	
	public void addReview(Review review) {
		String sql = "INSERT INTO Review(userId, resId, reviewText, recommandScore)" + "VALUES(?,?,?,?)";
		String sql2 = "UPDATE Account SET point=point + 10 WHERE userId=?";
		String sql3 = "UPDATE User A INNER JOIN Account B ON "
				+ "A.uid=B.userId "
				+ "SET A.grade = "
				+ "CASE WHEN B.point >= 300 THEN '계란' "
				+ "WHEN B.point >=700 THEN '타조알' "
				+ "WHEN B.point >=1200 THEN '독수리알'"
				+ " ELSE '메추리알'"
				+ "END";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setLong(1, review.getUserId());  //session으로 유저아이디 연결해보자 
				pstmt.setLong(2, review.getResId());
				pstmt.setString(3, review.getReviewText());
				pstmt.setDouble(4, review.getRecommandScore());
				pstmt.executeUpdate();
				System.out.println("리뷰완료");
				pstmt = con.prepareStatement(sql2);
				pstmt.setLong(1, review.getUserId());
				pstmt.executeUpdate();
				System.out.println("포인트업");
				pstmt = con.prepareStatement(sql3);
				pstmt.executeUpdate();
				System.out.println("등급확인.");
			} finally  {
				dataSource.close(pstmt,con);	
			}	
			System.out.println("NEW Review INSERTED.....\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void updateAccount(Review review) {
		String sql = "UPDATE Review SET reviewText=?, regDate=? WHERE userId=?";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, review.getReviewText());
				pstmt.setDate(2, (Date)review.getRegDate());
				pstmt.executeUpdate();
			} finally  {
				dataSource.close(pstmt,con);	
			}	
			System.out.println("NEW Review UPDATE.....\n");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Review> findReview(){
		String sql = "SELECT * FROM Review";
		List<Review> reviewList = new ArrayList<>();
		
		 try {
			 Connection con = null;
			 PreparedStatement pstmt = null;
			 ResultSet rs = null;
			try {
				con = dataSource.getConnection();  //DriverManager.getConnection 코드를 바꿔도 상관없다?? DataSourceManager메소드에서 연결시키기 때문에?
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					Review c = new Review();
					c.setUserId(rs.getLong("userId"));
					c.setResId(rs.getLong("resId"));
					c.setReviewText(rs.getString("reviewText"));
					c.setRecommandScore(rs.getInt("recommandScore"));
					reviewList.add(c);
					}
				} finally {
					dataSource.close(rs,pstmt,con);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reviewList;
	}

}
