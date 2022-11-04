package com.matjo.rsrs.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.management.RuntimeErrorException;

public class DataSource {
	private String jdbcDriver;
	private String jdbcUrl;
	private String jdbcUsername;
	private String jdbcPassword;
	
	public DataSource(String jdbcDriver, String jdbcUrl, String jdbcUsername, String jdbcPassword) {
		super();
		this.jdbcDriver = jdbcDriver;
		this.jdbcUrl = jdbcUrl;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
		try {
			Class.forName(jdbcDriver);
		} catch(ClassNotFoundException e) {
			throw new RuntimeException("JdbcDriverNotAvailableException");
		}
	}
	

	public  Connection getConnection() {
		try {
			return DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			throw new RuntimeException("ConnectionNotAvailableException");
		}
	}

	
	public void close(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if(rs != null && !rs.isClosed()) {
			rs.close();
		}
		if(pstmt != null && !pstmt.isClosed()) {
			pstmt.close();
		}
		if(con != null && !con.isClosed()) {
			con.close();
		}
		
	}

	
	public void close(PreparedStatement pstmt, Connection con) throws SQLException{
		close(null, pstmt, con);
	}
}
