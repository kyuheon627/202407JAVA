package java0730;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Ex6 {

	public static void main(String[] args) {
		
		List<Score> list = new ArrayList<>();
		
		String URL = "jdbc:mysql://localhost:3307/spring5fs";
		
		
		try (Connection conn = DriverManager.getConnection(URL, "root", "mysql");
			     Statement stmt = conn.createStatement();
			     ResultSet rs = stmt.executeQuery("SELECT * FROM score")){
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int math = rs.getInt("math");
				list.add(new Score(num, name, kor, eng, math));
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		list.stream().forEach(System.out::println);
		
		int korSum = list.stream().mapToInt(s->s.getKor()).sum();
		System.out.println("국어총점 : " + korSum);
		OptionalDouble korAvg = list.stream().mapToInt(s->s.getKor()).average();
		korAvg.ifPresent(avg -> System.out.println("국어평균 : " + avg));
		
		int engSum = list.stream().mapToInt(s->s.getEng()).sum();
		System.out.println("영어총점 : " + engSum);
		OptionalDouble engAvg = list.stream().mapToInt(s->s.getEng()).average();
		korAvg.ifPresent(avg -> System.out.println("영어평균 : " + avg));
		
		int mathSum = list.stream().mapToInt(s->s.getMath()).sum();
		System.out.println("수학총점 : " + mathSum);
		OptionalDouble mathAvg = list.stream().mapToInt(s->s.getMath()).average();
		korAvg.ifPresent(avg -> System.out.println("수학평균 : " + avg));
		
		int totSum = list.stream().mapToInt(s->s.getSum()).sum();
		System.out.println("전체총점 : " + totSum);
		OptionalDouble totAvg = list.stream().mapToDouble(s->s.getAvg()).average();
		totAvg.ifPresent(avg -> System.out.println("전체평균 : " + avg));
	}

}
