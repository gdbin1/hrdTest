package com.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.conn.DBConnection;

public class Ex1 {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void result() {
		
		try {
			String SQL = "SELECT title FROM book\r\n"
					+ "WHERE Pubyear >= 2020";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(SQL);
			
//			YEAR타입의 ? 바인딩
			pstmt.setString(1, "2020");
			rs = pstmt.executeQuery();
			
//			rs 출력
			System.out.println("(1) 2020년 이상 (>=) 출판된 도서를 검색하시오.");
			while (rs.next()) {
				String title = rs.getString("title");
				System.out.println("책 제목 : " + title);
			}
			System.out.println("---------------------------------------");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs,pstmt, conn);
		}

	}

}
