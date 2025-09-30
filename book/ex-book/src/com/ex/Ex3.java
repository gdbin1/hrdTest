package com.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.conn.DBConnection;

public class Ex3 {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void result() {
		
		try {
			String SQL = "SELECT book.Title, rental.RentDate\r\n"
					+ "FROM rental\r\n"
					+ "INNER JOIN book ON rental.BookID = book.BookID\r\n"
					+ "WHERE rental.ReturnDate IS NULL";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
//			YEAR타입의 ? 바인딩
			pstmt.setString(1, "2020");
			rs = pstmt.executeQuery();
			
//			rs 출력
			System.out.println("(3) 반납하지 않은 도서를 검색하시오.");
			while (rs.next()) {
				String title = rs.getString("title");
				System.out.println("반납하지 않은 책 : " + title);
			}
			System.out.println("---------------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs,pstmt, conn);
		}

	}

}
