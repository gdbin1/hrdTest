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
			String sql = "SELECT M.CustNo, M.CustName, SUM(S.Price * S.Amount) AS Total\r\n"
					+ "FROM ShopMember M\r\n"
					+ "LEFT JOIN Sale S ON M.CustNo = S.CustNo\r\n"
					+ "GROUP BY M.CustNo, M.CustName";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("(4-1) / 회원별 총 구매금액을 구하시오. (회원번호,회원성명,총금액)");
			while (rs.next()) {
				int CustNo = rs.getInt("CustNo");
				System.out.print("회원번호 : " + CustNo);
				String CustName = rs.getString("CustName");
				System.out.print(" | 회원이름 : " + CustName);
				int Total = rs.getInt("Total");
				System.out.println(" | 총금액 : " + Total);
			}
			System.out.println("--------------------------------");
			if (pstmt != null) pstmt.close();
			if (rs != null) rs.close();
			String sql2 = "SELECT CustName, SUM(S.Price * S.Amount) AS totalPrice\r\n"
					+ "FROM shopmember M\r\n"
					+ "LEFT JOIN sale S ON M.CustNo = S.CustNo\r\n"
					+ "GROUP BY M.Custname, S.Price\r\n"
					+ "ORDER BY totalPrice DESC\r\n"
					+ "LIMIT 1";
			pstmt = conn.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			System.out.println("(4-2) / 가장 구매금액이 높은 회원의 이름과 금액을 조회하시오.");
			while (rs.next()) {
				String CustName2 = rs.getNString("CustName");
				System.out.print("부자 : " + CustName2);
				int totalPrice = rs.getInt("totalPrice");
				System.out.println(" | 쓴 돈 : " + totalPrice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, pstmt, conn);
		}
		
	}

}
