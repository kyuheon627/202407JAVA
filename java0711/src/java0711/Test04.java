package java0711;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {

		// 1부터 n까지의 합과 그 값을 구하는 과정을 출력하는 프로그램을 작성하세요.
		
		Scanner scan = new Scanner(System.in);
		
		int sum = 0;
		
		System.out.print("값을 입력해주세요 : ");
		int num = scan.nextInt();
		
		
		for(int i=1; i<=num; i++) {
			
			if(i != num) {
				System.out.print(i + " + ");
				
			}else {
				System.out.print(i);
			}
			
			sum += i;
		}
		
		System.out.println(" = " + sum);
		
	}

}
