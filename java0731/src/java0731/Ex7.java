package java0731;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class Ex7 {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		
		// 오류가 발생함
//		double avg = list.stream()
//				.mapToInt(Integer::intValue)
//				.average()
//				.getAsDouble();
//		System.out.println(avg);
		
		// 첫 번째 방법
		OptionalDouble avg = list.stream()
				.mapToInt(Integer::intValue)
				.average();
		if(avg.isPresent()) {
			System.out.println(avg.getAsDouble());
		}else {
			System.out.println("값이 없다");
		}
		
		// 두 번재 방법
		double avg1 = list.stream()
				.mapToInt(Integer::intValue)
				.average()
				.orElse(0.0);
		System.out.println(avg1);
		
		// 세 번째 방법
		list.stream()
		.mapToInt(Integer::intValue)
		.average()
		.ifPresent(a->{
			System.out.println(a);
		});
	}

}
