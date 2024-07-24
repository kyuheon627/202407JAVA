package java0724;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex3 {

	public static void main(String[] args) {

		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO dept(deptno, dname, loc) VALUES(?, ?, ?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩!");
			conn = DriverManager.getConnection(URL, "root", "mysql");
			System.out.println("Mysql 접속 성공!");
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 1007);
			pstmt.setString(2, "인사부");
			pstmt.setString(3, "인천");
			int ret = pstmt.executeUpdate();
			System.out.println(ret + "건 insert 완료");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
