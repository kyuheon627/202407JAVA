package java0725;

import java.util.Arrays;
import java.util.Comparator;

public class StudentEx {

	public static void main(String[] args) {

		Student[] std = {
				new Student("홍길동", 100),
				new Student("홍길동2", 90),
				new Student("홍길동3", 87),
				new Student("홍길동4", 92),
				new Student("홍길동5", 78),
		};
		
		Comparator<Student> c = new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				
				return Integer.compare(o2.getScore(), o1.getScore());
				
			}
		};
		
		Arrays.sort(std, c);
		for(Student st : std) {
			System.out.println(st);
		}
		
	}

}
