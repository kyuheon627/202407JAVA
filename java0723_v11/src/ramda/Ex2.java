package ramda;

public class Ex2 {

	public static void main(String[] args) {

		MyInterface myInter = new MyInterface() {
			@Override
			public void method() {
				System.out.println("method()");
			}
		};
		myInter.method();
		
		// 람다식
		MyInterface myInter2 = ()->{
			System.out.println("method()");
		};
		myInter2.method();
	}

}
