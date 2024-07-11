package java0711;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		
		// for문으로 1부터 n까지의 합을 구하세요 (n은 입력받은 정수)

		Scanner scan = new Scanner(System.in);
		int sum = 0;
		
		System.out.print("숫자를 하나 입력하세요 : ");
		int num = scan.nextInt();
		
		
		for(int i=1; i<=num; i++) {
			sum += i;
		}
		
		System.out.println("합은 " + sum + "입니다.");
		
	}

}
