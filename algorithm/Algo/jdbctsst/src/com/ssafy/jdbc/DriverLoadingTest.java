package com.ssafy.jdbc;

public class DriverLoadingTest {

	public DriverLoadingTest() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("로딩 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("실패 ");
		}

	}

	public static void main(String[] args) {
		new DriverLoadingTest();
	}

}
