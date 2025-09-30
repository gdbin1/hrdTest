package com.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.conn.DBConnection;

public class Ex4 {

	public Ex4() {
		
		deleteEmployee("1");
	}
	
	
	private void deleteEmployee(String EmpNo) {
		System.out.println("레코드 삭제");
		String sql = "DELETE \r\n"
				+ "FROM employee\r\n"
				+ "WHERE EmpNo = 1";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, EmpNo);
			int rows = pstmt.executeUpdate();
			System.out.println("---" + rows + "----삭제됨");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
		System.out.println("삭제끝");
	}


	public void result() {
		
		
	}

}
