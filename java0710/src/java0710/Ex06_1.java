package java0710;

import java.util.Scanner;

public class Ex06_1 {

	public static void main(String[] args) {

		boolean run = true;
		int balance = 0;
		String userId = "";
		String userPw = "";
		
		Scanner scan = new Scanner(System.in);
		
		while(run) {
			
			System.out.println("-------------------------------");
			System.out.println("1.로그인 | 2.회원가입 | 3.종료");
			System.out.println("-------------------------------");
			System.out.print("선택> ");
			
			String choose = scan.nextLine();
			switch(choose) {
				case "1" :
					System.out.println("로그인");
					System.out.print("아이디 : ");
					if(scan.next().equals(userId)) {
						
						System.out.print("비밀번호 : ");
						if(scan.next().equals(userPw)){
							
							while(run) {
								System.out.println("-------------------------------");
								System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
								System.out.println("-------------------------------");
								System.out.print("선택> ");
								
								choose = scan.nextLine();
								switch(choose) {
									case "1" :
										System.out.print("예금액> ");
										balance += scan.nextInt();
										break;
									case "2" :
										System.out.print("출금액> ");
										balance -= scan.nextInt();
										break;
									case "3" :
										System.out.print("잔고> ");
										System.out.println(balance);
										break;
									case "4" :
										break;
								}
							}
							
						}else {
							System.out.println("비밀번호가 틀립니다.");
						}
						
					}else {
						System.out.println("없는 아이디 입니다.");
					}
					break;
				
				case "2" : 
					System.out.println("회원가입");
					System.out.print("아이디 : ");
					userId = scan.next();
					
					System.out.print("비밀번호 : ");
					userPw = scan.next();
					
					System.out.println("회원가입 완료");
					
					break;
					
				case "3" :
					run = false;
					break;
			}
		
		}

		System.out.println("프로그램 종료");
	}

}
