package com.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.conn.DBConnection;

public class Ex5 {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void result() {
		
		try {
			String SQL = "SELECT title, Price\r\n"
					+ "FROM book\r\n"
					+ "ORDER by price desc\r\n"
					+ "LIMIT 1;";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
//			YEAR타입의 ? 바인딩
			pstmt.setString(1, "2020");
			rs = pstmt.executeQuery();
			
//			rs 출력
			System.out.println("(5) 가격이 가장 비싼 도서를 출력하시오.");
			while (rs.next()) {
				String title = rs.getString("title");
				System.out.println("젤 비싼 책 : " + title);
				String price = rs.getString("price");
				System.out.println("가격 : " + price);
			}
			System.out.println("---------------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs,pstmt, conn);
		}

	}

}
