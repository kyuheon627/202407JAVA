package java0731_v21;

public class Ex6 {

	public static void method1(Object obj) {
		switch(obj) {
			case Integer i -> {
				System.out.println(i);
			}
			case String s -> {
				System.out.println("\"" + s + "\"");
			}
			case null, default -> {
				System.out.println("모른다");
			}
		}
	}

	public static void main(String[] args) {

		method1(10);
		method1("10");
		method1(null);
		
	}

}
