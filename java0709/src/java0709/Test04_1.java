package java0709;

import java.util.Scanner;

public class Test04_1 {

	public static void main(String[] args) {
		
		//3개의 정수값을 받아서 최대값을 구하여 출력하여 보세요
		//ㄴ> 배열에 정수값들을 받아서 최대값을 구하기
		
		Scanner scan = new Scanner(System.in);
		
		int[] numList = new int[100];
		int numMax = 0;
		
		for(int i=0; i<100; i++) {
			numList[i] = scan.nextInt();
			
			if(numList[i] == 0) 
				break;
				
		}
				
		for(int i=0; i<100; i++) {
			
			for(int j=i+1; j<100; j++) {
				
				if(numList[j] == 0)
					break;
				
				if(numList[i] < numList[j])
					numMax = numList[j];
				
			}
			
			if(numList[i] == 0)
				break;
			
		}
		
		System.out.println(numMax);
		
	}

}
