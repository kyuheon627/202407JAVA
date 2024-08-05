package java0731;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Ex3 {

	public static void main(String[] args) {

		List<Student> list = Arrays.asList(
				new Student("홍길동", 90),
				new Student("강하나", 92),
				new Student("김하나", 100)
		);
		
		// 첫 번째 sum방법
		int sum = list.stream().mapToInt(s->s.getScore()).sum();
		System.out.println(sum);
		
		// 두 번째 sum방법
		int sum2 = list.stream().mapToInt(Student::getScore).sum();
		System.out.println(sum2);
		
		// 두 번째 방법으로 average 사용방법
		OptionalDouble avg = list.stream().mapToInt(Student::getScore).average();
		System.out.println(avg);
		
		// Optional을 사용하지 않은 경우, 리스트가 null일때 컴파일적으로 문제는 없지만 실행시 오류가 발생함 
		double avg2 = list.stream().mapToInt(Student::getScore).average().getAsDouble();
		System.out.println(avg);
	}

}
