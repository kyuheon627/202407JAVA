package iterator2;

import java.util.Iterator;

public class Class implements Iterable<Student>{
	
	private Student[] students;
	private int last = 0;

	@Override
	public Iterator<Student> iterator() {
		return new ClassIterator(this);
	}

	public Class(int maxStudent) {
		this.students = new Student[maxStudent];
	}

	public Student getStudentAt(int index) {
		return students[index];
	}

	public void appendStudent(Student student) {
		this.students[last] = student;
		last++;
	}
	
	public int getLength() {
		return last;
	}
	
}
