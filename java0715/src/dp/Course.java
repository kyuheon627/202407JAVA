package dp;

import java.util.Vector;

public class Course {
	
	private String id;
	private String name;
	private int numOfStudent = 0;
	private Vector<Student> students;
	
	
	
	public Course() {
		super();
	}

	public Course(String id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.students = new Vector<Student>();
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}

	public void addStudent(Student students){

	}
	public void deleteStudent() {
		
	}


	public Vector<Student> getStudents() {
		return students;
	}
	
	
	
}
