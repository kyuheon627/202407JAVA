package java0709;

import java.util.Scanner;

public class Test06 {

	public static void main(String[] args) {

		//정수의 값을 입력받고 입력받은 값이 양의 정수이면 그냥 출력하고 음의 정수이면 양의 정수로 반환하여 출력하세요.
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("값을 입력해주세요 : ");
		int num = scan.nextInt();
		
		if(num < 0) {
			num *= -1;
			System.out.println(num);
		}else
			System.out.println(num);
		
	}

}
