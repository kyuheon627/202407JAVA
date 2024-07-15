package dp;

import java.util.Vector;

public class Student {

	private Professor advisor;
	private String name;
	private String id;
	private Vector<Course> courses;
	
	public Student() {}
	

	public Student(String name, String id) {
		super();
		this.name = name;
		this.id = id;
		this.courses = new Vector<Course>();
	}


	public void registerCourse(Course course) {
		courses.add(course);
	}
	public void dropCourse(Course course) {
		if(courses.contains(course)) {
			courses.remove(course);			
		}
	}
	

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", courses=" + courses + "]";
	}
	
}
