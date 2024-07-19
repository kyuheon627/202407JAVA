package java0719;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Project1_2 {

	public static void main(String[] args) {

		String createString = "INSERT INTO `dept` (`DEPTNO`, `DNAME`, `LOC`) VALUES"
				+ "(10, 'ACCOUNTING', 'NEW YORK'),"
				+ "(20, 'RESEARCH', 'DALLAS'),"
				+ "(30, 'SALES', 'CHICAGO'),"
				+ "(40, 'OPERATIONS', 'BOSTON');";
		
		String URL = "jdbc:mysql://localhost:3306/spring5fs";
		Connection con = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, "spring5", "spring5");
			System.out.println("MySQL 접속 성공!");
			stmt = con.createStatement();
			int num = stmt.executeUpdate(createString);
			System.out.println("테이블 생성!" + num);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
