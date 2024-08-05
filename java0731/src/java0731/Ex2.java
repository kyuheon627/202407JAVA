package java0731;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;

public class Ex2 {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		Properties properties = new Properties();	// Properties는 HashMap특성을 가짐
		String path = Ex2.class.getResource("database.properties").getPath();	// Ex2클래스의 패키지 내의 파일의 Path값을 가져옴
		path = URLDecoder.decode(path, "utf-8");	// 가져온 Path파일을 utf-8로 바꿈
		System.out.println(path);
		properties.load(new FileReader(path));		// 가져온 properties파일을 Properties객체에 넣어줌
		
		String driver = properties.getProperty("driver");	// properties의 value값을 이용해 데이터 값을 가져옴
		System.out.println("드라이버 : " + driver);
		String username = properties.getProperty("username");
		System.out.println("유저이름 : " + username);
	}

}
