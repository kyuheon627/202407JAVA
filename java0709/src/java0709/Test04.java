package java0709;

import java.util.Scanner;

public class Test04 {
	
	public static int maxNum(int a, int b, int c) {
		
		int max = 0;
		
		if(a > b && a > b)
			max = a;
		else if(b > a && b > c)
			max = b;
		else if(c > a && c > b)
			max = c;
		
		return max;
	}

	public static void main(String[] args) {

		//3개의 정수값을 받아서 최대값을 구하여 출력하여 보세요
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("첫 번째 값을 입력하세요 : ");
		int num1 = scan.nextInt();
		
		System.out.print("두 번째 값을 입력하세요 : ");
		int num2 = scan.nextInt();
		
		System.out.print("세 번째 값을 입력하세요 : ");
		int num3 = scan.nextInt();
		
		int max = maxNum(num1, num2, num3);
		
		System.out.println("최대값은 : " + max + "입니다.");
		
			
	}

}
