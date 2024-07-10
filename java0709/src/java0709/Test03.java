package java0709;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		
		//두 개의 값을 받아서 큰 수를 출력하세요 (단, 같으면 0으로 출력)
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("첫 번째 값을 입력하세요 : ");
		int num1 = scan.nextInt();
		
		System.out.print("두 번째 값을 입력하세요 : ");
		int num2 = scan.nextInt();
		
		if(num1 < num2)
			System.out.println("더 큰 값은 " + num2 + "입니다.");
		else if(num1 > num2)
			System.out.println("더 큰 값은 " + num1 + "입니다.");
		else
			System.out.println("둘의 값이 같습니다.");
		
	}

}
