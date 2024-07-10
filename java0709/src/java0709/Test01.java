package java0709;

public class Test01 {

	public static void main(String[] args) {
		
		//x=10, y=20 일 때 두 변수의 값을 바꿔보세요
		
		int x=10;
		int y=20;
		
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		
		swap(x,y);
		

	}

	public static void swap(int a, int b) {
		
		int tmp = a;
		a = b;
		b = tmp;
		
		System.out.println("x = " + a);
		System.out.println("y = " + b);
	}
	
}
