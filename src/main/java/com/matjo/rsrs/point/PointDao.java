package com.matjo.rsrs.point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.matjo.rsrs.data.DataSource;
import com.matjo.rsrs.data.NamingService;



public class PointDao {
	private DataSource dataSource;
	public PointDao() {
		NamingService namingService = NamingService.getInstance();
		dataSource =(DataSource) namingService.getAttribute("dataSource");
	}
	
	public boolean isValidUser(String userId) {
	      String sql = "SELECT point FROM Account WHERE userId=?";
	      boolean result = true;
	      try {
	         Connection con = null;
	         PreparedStatement pstmt = null;
	         ResultSet rs = null;
	         try {
	            con = dataSource.getConnection();
	            pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, userId);
	            rs = pstmt.executeQuery();
	            System.out.println(rs);
	            if(!rs.next()) {
	               result = false;
	            }
	         } finally {
	            dataSource.close(rs, pstmt, con);
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }      
	      return result;
	   }
	
	public int addPoint(int addNum) {
		String sql = "UPDATE Account SET point = point + ? WHERE userId = ? ";
		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(sql);
				
				pstmt.executeUpdate();
			}finally {
				dataSource.close(pstmt,con);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
