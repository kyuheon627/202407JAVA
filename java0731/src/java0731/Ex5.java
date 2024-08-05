package java0731;

import java.util.Arrays;
import java.util.List;

public class Ex5 {

	public static void main(String[] args) {

		List<Member> list = Arrays.asList(
				new Member("훙길동", Member.MALE, 30),
				new Member("박길동", Member.MALE, 27),
				new Member("강하나", Member.FEMALE, 31),
				new Member("김길동", Member.MALE, 35),
				new Member("이하나", Member.FEMALE, 24)
		);
		
		// 전체 평균 나이
		double avg = list.stream().mapToInt(a->a.getAge()).average().orElse(0);
		System.out.println(avg);
		
		// 남자 평균 나이
		double avg1 = list.stream()
				.filter(x->x.getSex() == Member.MALE)
				.mapToInt(a->a.getAge())
				.average()
				.orElse(0);
		System.out.println(avg1);
	}

}
