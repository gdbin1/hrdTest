package com.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.conn.DBConnection;

public class Ex3 {
	public Ex3() {
		updateEmployee("이순신",3500000);
	}
	
	private void updateEmployee(String EmpName, int Salary) {
		System.out.println("레코드 수정하기");
		String sql = "UPDATE employee\r\n"
				+ "SET salary = 3500000\r\n"
				+ "WHERE EmpNo = 2";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Salary);
			pstmt.setString(2, EmpName);
			int rows = pstmt.executeUpdate();
			System.out.println("---" + rows + "수정됨 --");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
		System.out.println("수정 끝");
	}

	public void result() {
		// TODO Auto-generated method stub
		
	}
}



