package com.matjo.rsrs.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.matjo.rsrs.data.DataSource;
import com.matjo.rsrs.data.NamingService;

public class UserDao {
	private DataSource dataSource;
	private String grade;
	
	public UserDao() {
		NamingService namingService = NamingService.getInstance();
		dataSource =(DataSource) namingService.getAttribute("dataSource");
	}
	
	public String findGradeByUserId(String userId) {
	      String sql = "SELECT grade FROM User WHERE userId = ?";
	      long rid = 0;
	      String grade = "";
		try {
	         Connection con = null;
	         PreparedStatement pstmt = null;
	         ResultSet rs = null;
	         try {
	            con = dataSource.getConnection();
	            pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, userId);
	            rs = pstmt.executeQuery();
	            User user = null;
	            while(rs.next()) {
	               user = new User();
	               grade = rs.getString("grade");
	            }
	            
	         } finally {
	            dataSource.close(rs, pstmt, con);
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
		
		return grade;
	   }
	
	public void addUser(User user) {	
		String sql = "INSERT INTO User(userName, userId, passwd, nickname)"
				+ "VALUE(?, ?, ?, ?)";
		String sql2 = "INSERT INTO Account(userId, point) values(?, 30)";
		
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, user.getUserName());
				pstmt.setString(2, user.getUserId());
				pstmt.setString(3, user.getPasswd());
				pstmt.setString(4, user.getNickname());
				pstmt.execute();
				System.out.println("USER INSERTED.....");
				pstmt = con.prepareStatement(sql2);
				User user2 = getUserId(user.getUserId());
				pstmt.setLong(1, user2.getuId());
				pstmt.execute();
				System.out.println("USER POINT INSERTED.....");
			}finally {
				dataSource.close(pstmt,con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public User getUserId(String userId) {
	      String sql = "SELECT uId FROM User WHERE userId=?";
	      long rid = 0;
	      try {
	         Connection con = null;
	         PreparedStatement pstmt = null;
	         ResultSet rs = null;
	         try {
	            con = dataSource.getConnection();
	            pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, userId);
	            rs = pstmt.executeQuery();
	            User user = null;
	            while(rs.next()) {
	               user = new User();
	               user.setuId(rs.getLong("uId"));
	               return user;
	            }
	            
	         } finally {
	            dataSource.close(rs, pstmt, con);
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	            
	      return null;
	   }
	

	
	public boolean isUserPosition(String userId, String passwd) {
	      String sql = "SELECT position FROM User WHERE userId = ? and passwd = ?";
	      boolean result = true;
	      try {
	         Connection con = null;
	         PreparedStatement pstmt = null;
	         ResultSet rs = null;
	         try {
	            con = dataSource.getConnection();
	            pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, userId);
	            pstmt.setString(2, passwd);
	            rs = pstmt.executeQuery();
	            User user = null;
	            if(rs.next()) {
	            	user = new User();
	            	user.setPosition(rs.getString("position").charAt(0));
	            	if(user.getPosition() == 'M') {
	            		result =  false;
	            	}
	            }
	         } finally {
	            dataSource.close(rs, pstmt, con);
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }      
	      return result;
	   }
	
	public boolean isValidUser(String userId, String passwd) {
		  String sql = "SELECT * FROM User WHERE userId = ? and passwd = ?";
	      boolean result = true;
	      try {
	         Connection con = null;
	         PreparedStatement pstmt = null;
	         ResultSet rs = null;
	         try {
	            con = dataSource.getConnection();
	            pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, userId);
	            pstmt.setString(2, passwd);
	            rs = pstmt.executeQuery();
	            if(!rs.next()) {
	            	result = false;
	            	return result;
	            }
	         } finally {
	            dataSource.close(rs, pstmt, con);
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }      
	      return result;
	}
	
		


}
