package com.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.conn.DBConnection;

public class Ex1 {

	public Ex1() {
//		insertMember();
		insertMember (1,"홍길동", "010-1234-5678", "서울시 강남구", "2020-01-01", "A", "01");
		insertMember (2,"이순신", "010-2222-3333", "부산시 해운대구", "2021-03-15", "B", "02");
		insertMember (3,"강감찬", "010-7777-8888", "대구시 달서구", "2019-05-20", "C", "03");
	}
	
	private void insertMember(int CustNo, String CustName, String Phone, String Address, String JoinDate, String Grade, String City) {
	System.out.println("테이블에 레코드 추가");
	String sql ="INSERT INTO ShopMember (CustNo, CustName, Phone, Address, JoinDate, Grade, City) VALUES (?,?,?,?,?,?,?)";
	Connection conn = null;
	PreparedStatement pstmt = null;
	try {
		conn = DBConnection.getConnection();
		pstmt = conn.prepareStatement(sql);

		pstmt.setInt(1, CustNo);
		pstmt.setString(2, CustName);
		pstmt.setString(3, Phone);
		pstmt.setString(4, Address);
		pstmt.setString(5, JoinDate);
		pstmt.setString(6, Grade);
		pstmt.setString(7, City);
		
		int rows = pstmt.executeUpdate();
		System.out.println("--" + rows + "행 추가");
		
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		DBConnection.close(pstmt,conn);
	}
	System.out.println("추가 끝");
	}

	public void result() {
	
		
	}

	
	
}
