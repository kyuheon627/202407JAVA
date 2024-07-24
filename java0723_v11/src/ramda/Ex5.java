package ramda;

public class Ex5 {

	public static void main(String[] args) {

		MyInterface4 myInter = (a, b)->{
			return a+b;
		};
		
		
		System.out.println(myInter.method(100, 200));
	}

}
