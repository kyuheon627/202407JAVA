package java0709;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {

		//100점 만점의 학점을 입력받아서 90점 이상이면 A, 80점 이상이면 B, 70점 이상이면 C, 60점 이상이면 D, 60점 미만이면 F를 구하는 프로그램을 작성하세요
		//(입력받은 점수는 0점에서 100점 사이의 값만 넣어야 함)
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("점수를 입력해주세요 : ");
		int score = scan.nextInt();
		String rank = (score >= 90) ? "A" : (score >= 80) ? "B" : (score >= 70) ? "C" : (score >= 60) ? "D" : "F";
		
		
		
		/*
		switch (score/10) {
		case 10:
		case 9:
			rank = "A";
			break;
		
		case 8:
			rank = "B";
			break;
			
		case 7:
			rank = "C";
			break;
			
		case 6:
			rank = "D";
			break;
			
		default :
			rank = "F";
			break;
		}
		*/
		
		System.out.println("학점은 " + rank + "입니다.");
		
		
		
	}

}
