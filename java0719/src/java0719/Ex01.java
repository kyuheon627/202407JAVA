package java0719;

public class Ex01 {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Mysql 드라이버 로딩!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

}
