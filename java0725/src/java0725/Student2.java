package java0725;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student2 {

	public static void main(String[] args) {
		List<Student> list = new ArrayList<>();
		list.add(new Student("홍길동1", 100));
		list.add(new Student("홍길동2", 94));
		list.add(new Student("홍길동3", 67));
		list.add(new Student("홍길동4", 87));
		list.add(new Student("홍길동5", 71));
		
		Comparator<Student> c = new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {

			return Integer.compare(o2.getScore(), o1.getScore());
				
			}
		};
		Collections.sort(list, c);
		System.out.println(list);
	}

}
