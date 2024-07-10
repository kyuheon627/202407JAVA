package java0710;

public class Ex01 {

	public static void main(String[] args) {
		byte byte1 = 10;
		System.out.println(byte1);
		
		double d1 = 3.14;
		int z = (int)d1;
		System.out.println(z);
		
		byte a1 = 10;
		byte a2 = 20;
		byte a4 = (byte) (a1+a2);
		int a3 = a1 + a2;
		
		float f1 = 1.5f + 2.3f;
		double d2 = 1.5 + 2.3;
		
		int x = 1;
		int y = 2;
		double res1 = x/y;
		System.out.println(res1);
		double res2 = (double) x / y;
		System.out.println(res2);
		double res3 = x / (double)y;
		System.out.println(res3);
		double res4 = (double) x / (double) y;
		System.out.println(res4);
		
		String s1 = "3" + 7;
		System.out.println(s1);
		
		int i1 = Integer.parseInt("100")+1;
		
		String str1 = 10 + "";
		String str2 = String.valueOf(10);
		
		// https://git
		
	}

}
