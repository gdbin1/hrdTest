package com.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.conn.DBConnection;

public class Ex4 {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void result() {
		
		try {
			String SQL ="SELECT book.Title AS 도서명, count(rental.RentalID) AS 대출횟수\r\n"
					+ "FROM book\r\n"
					+ "LEFT JOIN rental ON book.BookID = rental.BookID\r\n"
					+ "GROUP BY title";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
//			YEAR타입의 ? 바인딩
			pstmt.setString(1, "2020");
			rs = pstmt.executeQuery();
			
//			rs 출력
			System.out.println("(4) 도서별 대출 횟수를 출력하시오.");
			while (rs.next()) {
				String title = rs.getString("도서명");
				String rentcnt = rs.getString("대출횟수");
				System.out.println("책 제목 : " + title + " = " + "대출 횟수 : " + rentcnt);
			}
			System.out.println("---------------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs,pstmt, conn);
		}

	}

}
