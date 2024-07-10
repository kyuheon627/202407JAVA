package java0709;

import java.util.Scanner;

public class Test02 {

	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {

		//사과가 10개 있습니다. 2명의 친구가 있습니다.(본인을 포함하면 총 3명)
		//사과를 똑같이 나눠 먹으면 몇 개의 사과가 남을까요? (Scanner 이용)
		
		System.out.print("사과의 갯수를 입력하세요 : ");
		//int apple = scan.nextInt();
		int apple = getCount();
		
		System.out.print("친구의 수를 입력하세요 : ");
		//int friend = scan.nextInt()+1;
		int friend = getCount()+1;
		
		System.out.println("남은 사과의 수는 : " + apple%friend);
		
	}
	
	public static int getCount() {
		
		int count = scan.nextInt();
		
		return count;
	}

}
