package java0712;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		
		// 2차원 배열을 이용하여 국어점수와 수학점수를 입력받아서 학생별 평균을 출력하는 프로그램을 작성하세요.

		Scanner scan = new Scanner(System.in);
		
		System.out.print("학생 수를 입력하세요 : ");
		int num = Integer.parseInt(scan.next());
		double scores[][] = new double[num][3];
		
		for(int i=0; i<scores.length; i++) {
			double avg = 0;
			System.out.println(i+1 + "번째 학생");
			for(int j=0; j<scores[i].length-1; j++) {
				if(j == 0) {
					System.out.print("국어점수를 입력하세요 : ");
				}else {
					System.out.print("수학점수를 입력하세요 : ");
				}
				scores[i][j] = Double.parseDouble(scan.next());
				avg += scores[i][j];
			}
			scores[i][2] = avg/2;
			System.out.println(i+1 + "번째 학생의 평균은 " + scores[i][2] + "입니다.");
			System.out.println();
		}
		
		System.out.print("\t국어\t수학\t펑균\n");
		System.out.println("===============================");
		for(int i=0; i<scores.length; i++) {
			System.out.printf("%d번 학생\t%3.2f\t%3.2f\t%3.2f\n", i+1, scores[i][0], scores[i][1], scores[i][2]);
		}
		
	}

}
