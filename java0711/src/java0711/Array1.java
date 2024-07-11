package java0711;

public class Array1 {

	public static void main(String[] args) {
		
		int score[] = new int[] {83, 90, 87};
		int score2[] = {83, 90, 87};
		
		//총점을 계산하시오
		int sum = 0;
		for(int i=0; i<score.length; i++) {
			sum += score[i];
		}
		System.out.println(sum);
		
		//평균을 계산하시오
		double rul = 0;
		for(int i=0; i<score.length; i++) {
			rul = sum/score.length;
		}
		System.out.println(rul);
		
		for(int i=0; i<score.length; i++) {
			System.out.println(score[i]);
		}

		int[] myArr = new int[5];
		
		for(int i=0; i<myArr.length; i++) {
			System.out.println(myArr[i]);
		}
		
		double[] myArr2 = new double[5];
		
		for(int i=0; i<myArr2.length; i++) {
			System.out.println(myArr2[i]);
		}
		
		boolean[] myArr3 = new boolean[5];
		
		for(int i=0; i<myArr3.length; i++) {
			System.out.println(myArr3[i]);
		}
		
	}

}
