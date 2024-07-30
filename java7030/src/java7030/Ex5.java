package java7030;

import java.util.stream.IntStream;

public class Ex5 {

	public static void main(String[] args) {

		IntStream ii = IntStream.range(1, 5);
//		ii.forEach(System.out::println);
		ii.forEach(a->{
			System.out.print(a + " ");
		});
		System.out.println();
		System.out.println("------------------------");
		
		IntStream ii2 = IntStream.rangeClosed(1, 5);
		ii2.forEach(a->{
			System.out.print(a + " ");
		});
		System.out.println();
		System.out.println("------------------------");
		
		// 문제2. IntStream을 이용하여 1부터 count까지 합계를 출력하는 코드를 만들어보세요. (int count = 10;)
		int count = 10;
		int sum = IntStream.rangeClosed(1, count).sum();
		System.out.println(sum);
	}

}
