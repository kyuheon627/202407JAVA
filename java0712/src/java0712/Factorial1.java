package java0712;

public class Factorial1 {
	
	// 재귀호출 메소드 (recursive)
	public static int fac2(int a) {
		if(a==0) {
			return 1;
		}else {
			return a * fac(a-1);
		}
	}
	
	public static int fac(int a) {
		
		int res = 1;
		
		for(int i=1; i<=a; i++) {
			res *= i;
		}
		
		return res;
	}

	public static void main(String[] args) {

		int num = 4;
		int result = fac(num);
		System.out.println(result);
		
		System.out.println(fac2(num));
		
	}

}
