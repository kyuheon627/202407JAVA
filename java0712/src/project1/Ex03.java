package project1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Ex03 {

	public static void main(String[] args) {
		
		Member[] list = {
				new Member("강하나", "911224", "010-1234-1234"),
				new Member("강두리", "940110", "010-1234-1234"),
				new Member("강세리", "990601", "010-1234-1234")
		};
		try(FileOutputStream fos = new FileOutputStream("c:\\temp\\members.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
			
			oos.writeObject(list);
			System.out.println("객체를 파일에 저장했습니다.");
					
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
