package iterator2;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {

		Class classroom = new Class(3);
		
		classroom.appendStudent(new Student("이규헌", "2407067"));
		classroom.appendStudent(new Student("홍길동", "2407001"));
		classroom.appendStudent(new Student("김자바", "2407002"));
		
		Iterator<Student> it = classroom.iterator();
		while(it.hasNext()) {
			Student student = it.next();
			System.out.println(student);
		}
		
		System.out.println("------------------");
		
		for(Student st1 : classroom) {
			System.out.println(st1);
		}
	}

}
