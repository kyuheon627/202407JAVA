package java0711;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {
		
		// +, - 기호를 번갈아 출력하는 프로그램을 작성하세요

		Scanner scan = new Scanner(System.in);
		
		System.out.print("첫 번째 기호 : ");
		String str1 = scan.next();
		System.out.print("두 번째 기호 : ");
		String str2 = scan.next();
		
		System.out.print("값을 입력해주세요 : ");
		int num = scan.nextInt();
		
		for(int i=0; i<num; i++) {
			if(i%2 == 0) {
				System.out.print(str1);
			}else {
				System.out.print(str2);
			}
		}
		
	}

}
