
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class jdbcEx9 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		Connection conn = null;
		Statement stmt = null;
		
		String sql2 = "select max(deptno) from dept";

		System.out.print("부서명 : ");
		String strName = scan.next();
		System.out.print("부서지역 : ");
		String strLoc = scan.next();
		
		String sql = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URL, "root", "mysql");
			System.out.println("접속 성공!");
			stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql2);
			rs.next();
			int strNo = rs.getInt(1);
			
			sql = String.format("insert into dept(deptno, dname, loc) values(%s, '%s', '%s')", strNo+1, strName, strLoc);
			
			int res = stmt.executeUpdate(sql);
			System.out.println(res + "건을 입력!!");
	
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
