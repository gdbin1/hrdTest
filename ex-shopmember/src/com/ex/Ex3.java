package com.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.conn.DBConnection;

public class Ex3 {

	public Ex3() {
//		insertSale();
		insertSale (1, 1000, 10, 10000, "P01");
		insertSale (2, 2000, 5, 10000, "P02");
		insertSale (3, 1500, 7, 10500, "P03");
	}
	
	private void insertSale(int CustNo, int PCost, int Amount, int Price, String PCode) {
		System.out.println("Sale테이블에 레코드 추가");
		String sql ="INSERT INTO Sale(CustNo, PCost, Amount, Price, PCode) VALUES(?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, CustNo);
			pstmt.setInt(2, PCost);
			pstmt.setInt(3, Amount);
			pstmt.setInt(4, Price);
			pstmt.setString(5, PCode);
			
			int rows = pstmt.executeUpdate();
			System.out.println("--" + rows + "행 추가");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(pstmt, conn);
		}
		System.out.println("추가 끝");
	}

	public void result() {
		
		
	}

}
