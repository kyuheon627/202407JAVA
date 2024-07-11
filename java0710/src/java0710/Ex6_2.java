package java0710;

import java.util.Scanner;

public class Ex6_2 {

	public static void main(String[] args) {

		boolean run = true;
		boolean run2 = true;
		int balance = 0;
		
		String loginID = "abc";
		String loginPW = "1234";
		
		String userName = "";
		String userID = "";
		String userNum = "";
		
		Scanner scan = new Scanner(System.in);
		
		while(run) {
			System.out.println("-------------------------------------");
			System.out.println("1.로그인 | 2.회원가입 | 3.예금/출금 | 4.종료");
			System.out.println("-------------------------------------");
			System.out.print("선택> ");
			
			int choose = scan.nextInt();
			
			switch(choose) {
				case 1 :
					System.out.println("로그인 처리");
					System.out.print("아이디 : ");
					String id = scan.next();
					System.out.println("패스워드 : ");
					String pw = scan.next();
					
					if(!id.equals(loginID)) {
						System.out.println("로그인 실패 : 없는 아이디입니다.");
					}else if(!pw.equals(loginPW)) {
						System.out.println("로그인 실패 : 패스워드가 틀립니다.");
					}else {
						System.out.println("로그인 성공");
					}
					
					break;
					
				case 2 :
					System.out.println("회원 가입");
					System.out.println("[필수정보 입력]");
					System.out.print("1. 이름 : ");
					userName = scan.next();
					System.out.print("2. 주민번호 앞 6자리 : ");
					userID = scan.next();
					System.out.print("3. 전화번호 : ");
					userNum = scan.next();
					
					System.out.println("[입력된 내용]");
					System.out.println("1. 이름 : " + userName);
					System.out.println("2. 주민번호 앞 6자리 : " + userID);
					System.out.println("3. 전화번호 : " + userNum);
					
					
					break;
					
				case 3 :
					run2 = true;
					
					while(run2) {
						System.out.println("-------------------------------");
						System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
						System.out.println("-------------------------------");
						System.out.print("선택> ");
						
						int choose2 = scan.nextInt();
						
						switch(choose2) {
							case 1 :
								System.out.print("예금액> ");
								balance += scan.nextInt();
								break;
							case 2 :
								System.out.print("출금액> ");
								int num2 = scan.nextInt();
								if(balance - num2 < 0) {
									System.out.println("잔액이 부족합니다");
								}else {
									balance -= num2;
								}
								break;
							case 3 :
								System.out.print("잔고> ");
								System.out.println(balance);
								break;
							case 4 :
								System.out.println("예금/출금 프로그램 종료");
								run2 = false;
								break;
						}
					}
					
					break;
					
				case 4 :
					run = false;
					break;
			}
		
		}
		
		System.out.println("프로그램 종료");
		
	}

}
