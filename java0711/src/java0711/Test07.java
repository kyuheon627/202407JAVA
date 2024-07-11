package java0711;

import java.util.Scanner;

public class Test07 {

	public static void main(String[] args) {

		// 2자리 양수를 입력받는 프로그램을 작성합니다
		
		Scanner scan = new Scanner(System.in);
		
		int n = 0;
		
		while(n > 10 || n < 100) {
			
			System.out.print("값을 입력해주세요 : ");
			n = scan.nextInt();
			
		}
		System.out.println(n);
		
	}

}
