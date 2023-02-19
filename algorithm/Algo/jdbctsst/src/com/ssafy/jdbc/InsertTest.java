package com.ssafy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

public class InsertTest {
    public InsertTest() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("로딩 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("로딩 실패");
        }
    }

private Connection getConnection() throws SQLException {
    return DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafydb?serverTimezone=UTC", "ssafy", "ssafy");

}

private int register(String name, int age) {
    int cnt = 0;
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
        conn = getConnection();
        StringBuilder sql = new StringBuilder("insert into jdbctest(name, age) \n");
        sql.append("values (?, ?);");
        pstmt = conn.prepareStatement(sql.toString());
        pstmt.setString(1, name);
        pstmt.setInt(2, age);
        
        cnt = pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }finally {
        try {
            if(pstmt !=null)
                pstmt.close();
            if(conn !=null)    
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    return cnt;
}

public static void main(String[] args) {
    InsertTest it = new InsertTest();
    int cnt = it.register("임규돈", 26);
    if(cnt != 0)
        System.out.println("등록 성공");
    else {
        System.out.println("등록 실패");
    }
}
}

