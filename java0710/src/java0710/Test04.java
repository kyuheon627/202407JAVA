package java0710;

public class Test04 {

	public static void main(String[] args) {
		// 1부터 100까지 짝수의 합을 구하시오
		
		int sum = 0;
		
		for(int i=1; i<=100; i++) {
			if(i%2 == 0) {
				sum += i;
			}
		}
		
		System.out.println(sum);

	}

}
