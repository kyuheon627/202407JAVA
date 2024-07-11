package java0711;

import java.util.Scanner;

public class Test01 {
	
	// 3개의 정수 값을 입력받아 중앙값을 구하고 출력하세요
	
	public static int MiddleNum(int fristNum, int secondNum, int thirdNum) {
		
		int middle = 0;
		
		if((fristNum >= secondNum && fristNum <= thirdNum) || (fristNum <= secondNum && fristNum >= thirdNum)) {
			middle = fristNum;
		}else if((secondNum >= fristNum && secondNum <= thirdNum) || (secondNum <= fristNum && secondNum >= thirdNum)) {
			middle = secondNum;
		}else {
			middle = thirdNum;
		}
		
		return middle;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		System.out.print("첫 번째 수 : ");
		int a = scan.nextInt();
		System.out.print("두 번째 수 : ");
		int b = scan.nextInt();
		System.out.print("세 번째 수 : ");
		int c = scan.nextInt();
		
		
		System.out.println("중간값은 " + MiddleNum(a, b, c) + "입니다.");
		
	}

}
