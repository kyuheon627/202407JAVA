package sec01.exam07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadEx2 {
	

	public static void main(String[] args) throws IOException {
		
		String line = "";
		BoardDAO dao = new BoardDAO();

		BufferedReader br = new BufferedReader(new FileReader("C:/Temp/board1.csv"));
		
		while((line = br.readLine()) != null) {
			String[] data = line.split(", ");
			
			BoardDTO dto = new BoardDTO(0, data[0], data[1], data[2], "", 0);
			System.out.println(dto);
			dao.insertBoard(dto);
		}
		System.out.println("insert 완료");
		br.close();
	}

}
