package com.ssafy.jdbc;

import java.sql.*;

public class ConnectionTest {
	
	
	public ConnectionTest() {
		try { //1. loading 먼저 
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("로딩 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("실패 ");
		}

	}
		
	
	public static void main(String[] args) {
		ConnectionTest ct = new ConnectionTest();
		//2. db 연결
		Connection conn = ct.getConnection();
		if(conn != null)
			System.out.println("DB연결 성공");
	}
	
	private Connection  getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC","ssafy","ssafy");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return conn;
	}

}
