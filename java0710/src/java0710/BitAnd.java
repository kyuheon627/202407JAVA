package java0710;

public class BitAnd {

	public static void main(String[] args) {
		
		int a = 60;
		int b = -60;
		System.out.printf("[%32s] %d\n", Integer.toBinaryString(a), a);
		System.out.printf("[%32s] %d\n", Integer.toBinaryString(b), b);
		System.out.printf("[%32s] %d\n", Integer.toBinaryString(a+b), a+b);
		System.out.printf("[%32s] %d\n", Integer.toBinaryString(a-b), a-b);
		System.out.printf("[%32s] %d\n", Integer.toBinaryString(a*b), a*b);
		System.out.printf("[%32s] %d\n", Integer.toBinaryString(a/b), a/b);
		System.out.printf("[%32s] %d\n", Integer.toBinaryString(a&b), a&b);
		System.out.printf("[%32s] %d\n", Integer.toBinaryString(a|b), a|b);
		
		
	}

}
