package ramda;

public class Ex4 {

	public static void main(String[] args) {

		MyInterface3 myInter = (a, b)->{
			System.out.println(a + " " + b);
		};
		myInter.method(10, 20);
	}

}
