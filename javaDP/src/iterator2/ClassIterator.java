package iterator2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ClassIterator implements Iterator<Student> {
	
	private Class classroom;
	private int index;
	
	

	public ClassIterator(Class classroom) {
		super();
		this.classroom = classroom;
		this.index = 0;
	}

	@Override
	public boolean hasNext() {

		if(index < classroom.getLength()) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public Student next() {
		
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		Student student = classroom.getStudentAt(index);
		index++;
		return student;
	}

}
