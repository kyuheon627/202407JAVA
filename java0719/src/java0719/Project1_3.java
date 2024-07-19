package java0719;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Project1_3 {

	public static void main(String[] args) {

		String createString = "CREATE TABLE IF NOT EXISTS `emp` ("
				+ "  `EMPNO` int(11) NOT NULL,"
				+ "  `ENAME` varchar(10) DEFAULT NULL,"
				+ "  `JOB` varchar(9) DEFAULT NULL,"
				+ "  `MGR` int(11) DEFAULT NULL,"
				+ "  `HIREDATE` date DEFAULT NULL,"
				+ "  `SAL` int(11) DEFAULT NULL,"
				+ "  `COMM` int(11) DEFAULT NULL,"
				+ "  `DEPTNO` int(11) DEFAULT NULL"
				+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
		
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
