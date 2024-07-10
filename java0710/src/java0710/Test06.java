package java0710;

import java.util.Scanner;

public class Test06 {

	public static void main(String[] args) {
		// 구구단 출력하기 (단 입력 받아서)
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("단을 입력해주세요 : ");
		int i = scan.nextInt();
		
		for(int j=1; j<=9; j++) {
			System.out.println(i + " x " + j + " = " + i*j);
		}

	}

}
