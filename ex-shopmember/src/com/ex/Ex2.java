package com.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.conn.DBConnection;

public class Ex2 {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void result() {
		try {
			String sql = "SELECT CustName, Phone, JoinDate\r\n"
					+ "FROM shopmember\r\n"
					+ "WHERE grade = 'A'";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "A");
			rs = pstmt.executeQuery();
			System.out.println("고객 등급이 A등급인 회원의 이름, 전화번호, 가입일자를 조회.");
			
			while(rs.next()) {
				String CustName = rs.getString("CustName");
				System.out.print("이름 : " + CustName);
				String Phone = rs.getString("Phone");
				System.out.print(" | 전화번호 : " + Phone);
				String JoinDate = rs.getString("JoinDate");
				System.out.println(" | 가입일자 : " + JoinDate);
				System.out.println("-----------------------------");
			}
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			
			String sql2 = "SELECT *\r\n"
					+ "FROM ShopMember\r\n"
					+ "WHERE YEAR(JoinDate) > 2020";
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, "2020");
			rs = pstmt.executeQuery();
			System.out.println("가입 일자가 2020년 이후인 회원을 조회");
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					String columnName = rsmd.getColumnName(i);
					String columnValue = rs.getString(i);
					
					System.out.println(columnName + " : " + columnValue);
					
//					if(i < columnCount) {
//						System.out.println(" | ");
//					}
				}
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, pstmt, conn);
		}
		
	}

}
