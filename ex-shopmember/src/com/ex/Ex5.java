package com.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.conn.DBConnection;

public class Ex5 {
	public Ex5() {
		updateTable("이순신", "A");
		deleteTable(3);
	}

	private void deleteTable(int CustNo) {
		System.out.println("CustNo = 3인 회원을 삭제.");
		String sql2 = "DELETE\r\n"
				+ "FROM sale\r\n"
				+ "WHERE CustNo = 3";
		Connection conn2 = null;
		PreparedStatement pstmt2 = null;
		
		try {
			conn2 = DBConnection.getConnection();
			pstmt2 = conn2.prepareStatement(sql2);
			pstmt2.setInt(1, CustNo);
			int rows2 = pstmt2.executeUpdate();
			System.out.println("-- 삭제됨" + rows2);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt2, conn2);
		}
		System.out.println("------------삭제 끝");
	}

	private void updateTable(String CustNo, String Grade) {
		System.out.println("이순신의 등급을 A로 변경");
		String sql = "UPDATE shopmember\r\n"
				+ "SET Grade = 'A'\r\n"
				+ "WHERE CustNo = 2";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, CustNo);
			pstmt.setString(2, Grade);
			int rows = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
	}
	

	public void result() {
		// TODO Auto-generated method stub
		
	}
}
