package ramda;

public class Ex3 {

	public static void main(String[] args) {

		MyInterface2 myInter = (a)->{
			System.out.println(a);
		};
		
		myInter.method(100);
	}

}
