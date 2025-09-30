package com.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.conn.DBConnection;

public class Ex1 {

	public Ex1() {
//		insertUsers();
		insertUsers(1,"홍길동", "영업부", "2020-03-01", 2500000);
		insertUsers(2,"이순신", "인사부", "2019-07-15", 3200000);
		insertUsers(3,"강감찬", "개발부", "2021-01-10", 2800000);

	}
	
	
	private void insertUsers(int EmpNo, String EmpName, String Dept, String HireDate, int salary) {
		System.out.println("테이블에 레코드 추가하기");
		String sql ="INSERT INTO Employee (EmpNo, EmpName, Dept, HireDate, Salary) VALUES (?, ?, ?, ?, ?)"; 
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, EmpNo);
			pstmt.setString(2, EmpName);
			pstmt.setString(3, Dept);
			pstmt.setString(4, HireDate);
			pstmt.setInt(5, salary);
			int rows = pstmt.executeUpdate();
			System.out.println("----" + rows + "행 추가");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(pstmt, conn);
		}
		System.out.println("--레코드 추가 끝");
	}


	public void result() {

		
	}

}
