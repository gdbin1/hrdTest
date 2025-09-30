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
			String SQL = "SELECT EmpNo, EmpName, salary\r\n"
					+ "FROM employee\r\n"
					+ "WHERE Dept = '개발부'";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, "개발부");
			rs = pstmt.executeQuery();
			System.out.println("(2-1) - 부서가 '개발부'인 사원의 사번, 이름, 급여를 조회하시오.");
			
			while (rs.next()) {
				String Empno = rs.getNString("EmpNo");
				System.out.print("사번 : " + Empno);
				String EmpName = rs.getNString("EmpName");
				System.out.print(" | 이름 : " + EmpName);
				String salary = rs.getNString("salary");
				System.out.println(" | 급여 : " + salary);
				System.out.println("----------------------");
			}
//		-------------------------------------------------------------
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
//		---------------------------------------------------------------
			String SQL2 ="SELECT EmpName, Dept\r\n"
					+ "FROM employee\r\n"
					+ "WHERE salary > ?";
			pstmt = conn.prepareStatement(SQL2);
			pstmt.setInt(1, 3000000);
			rs = pstmt.executeQuery();
			System.out.println("(2-2) - 급여가 3,000,000원 이상인 사원의 이름과 부서를 조회하시오.");
			
			while (rs.next()) {
				String EmpName2 = rs.getString("EmpName");
				System.out.print(" 이름 : " + EmpName2);
				String Dept2 = rs.getString("Dept");
				System.out.println(" | 부서 : " + Dept2);
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs,pstmt, conn);
		}
	}

}
