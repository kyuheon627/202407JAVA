package java0711;

import java.util.Scanner;

public class Test06_1 {

	public static void main(String[] args) {

		// *를 n개 출력하되 w개마다 줄을 바꿔서 출력하는 프로그램을 작성하세요
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("n 값을 입력해주세요 : ");
		int n = scan.nextInt();
		System.out.print("w 값을 입력해주세요 : ");
		int w = scan.nextInt();
		
		int n2 = n;
		
		for(int i=0; i<n/w; i++) {
			System.out.print("*");
		}
		
		int result = n%w;
		
		for(int i=0; i<result; i++) {
			System.out.print("*");
		}
		
		if(n%w != 0) {
			System.out.println();
		}
		System.out.println("완료!!");
	}

}
