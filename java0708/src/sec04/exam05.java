package sec04;

import java.util.Scanner;

public class exam05 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputData;
		
		while(true) {
			System.out.print("문자열을 입력해주세요 : ");
			inputData = scanner.nextLine();
			System.out.println("입력된 문자열:" + inputData);
			
			if(inputData.equals("q"))
				break;
		}
		
		System.out.println("종료");
	}

}
