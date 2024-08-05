package java0731;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class MyFileWriter {

	public static void main(String[] args) throws IOException {

		File dir = new File("C:/Temp/text");
		if(dir.exists() == false) {
			dir.mkdir();
		}

//		File file1 = new File("C:/Temp/text/file1.txt");
//		if(file1.exists() == false) {
//			file1.createNewFile();
//		}
		
		// 굳이 파일을 안만들어도 자동으로 생성됨
		Writer writer = new FileWriter("C:/Temp/text/file2.txt");
		String str = "ABC 안녕 자바";
		writer.write(str);
		writer.flush();
		writer.close();
	}

}
