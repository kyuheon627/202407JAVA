package java0711;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {

		// 정수 a, b를 포함하여 그 사이의 모든 정수의 합을 구하여 반환하는 메서드를 작성하세요
		
		Scanner scan = new Scanner(System.in);
		int sum = 0;
		
		System.out.print("첫 번째 값 : ");
		int num1 = scan.nextInt();
		System.out.print("두 번째 값 : ");
		int num2 = scan.nextInt();
		
		if(num1 <= num2) {
			for(int i = num1; i<=num2; i++) {
				sum += i;
			}
		}else {
			for(int i = num2; i<=num1; i++) {
				sum += i;
			}
		}
		
		System.out.println("두 수 사이의 모든 수의 합은 " + sum + "입니다.");
		
	}

}
