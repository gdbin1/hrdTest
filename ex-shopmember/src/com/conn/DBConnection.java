package com.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {

	private static final String URL = "jdbc:mariadb://localhost:3306/hrdtest";
	private static final String USER = "root";
	private static final String PASSWORD = "1234";
	
	public static Connection getConnection() {
		
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			System.out.println("DB연결됨");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("-- DB 연결 실패함--");
		}
		return conn;
		
	}

	public static void close(PreparedStatement pstmt, Connection conn) {
		try {
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if (pstmt != null)
				pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
