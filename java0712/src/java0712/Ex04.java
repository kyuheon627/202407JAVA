package java0712;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("숫자 입력 : ");
		int num = Integer.parseInt(scan.next());
		int arr[] = new int[num];
		
		for(int i=0; i<num; i++) {
			System.out.print(i+"번째 값:");
			arr[i] = Integer.parseInt(scan.next());
		}
		for(int n : arr) {
			System.out.println(n);
		}
	}

}
