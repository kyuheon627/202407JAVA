package java0731;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class Ex1 {
	
	static int sum = 0;

	public static void main(String[] args) {
		
		// 첫 번째 방법(람다식)
		IntStream.rangeClosed(1, 5).forEach(a->{
			sum += a;	// 람다식에서 다른 변수를 사용하려면 static으로 변수를 선언해야됨
		});
		System.out.println(sum);
		
		// 두 번째 방법(Consumer방식)
		IntStream.rangeClosed(1, 5).forEach(new IntConsumer() {
			
			@Override
			public void accept(int value) {
				System.out.println(value);
			}
		});
	}

}
