package com.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.conn.DBConnection;

public class Ex2 {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void result() {
		
		try {
			String SQL ="SELECT m.NAME AS 이름, b.Title AS 도서\r\n"
					+ "FROM member m\r\n"
					+ "INNER JOIN rental r ON m.MemberID = r.memberID\r\n"
					+ "INNER JOIN book b ON r.BookID = b.BookID\r\n"
					+ "WHERE m.NAME = '홍길동';\r\n"
					+ "";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
//			YEAR타입의 ? 바인딩
			pstmt.setString(1, "2020");
			rs = pstmt.executeQuery();
			
//			rs 출력
			System.out.println("(2) '홍길동' 회원이 대출한 도서 목록을 출력하시오.");
			while (rs.next()) {
				String name = rs.getString("이름");
				System.out.println("이름 : " + name);
				String name2 = rs.getString("도서");
				System.out.println("빌려간 책 : " + name2);
			}
			System.out.println("---------------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs,pstmt, conn);
		}

	}

}
