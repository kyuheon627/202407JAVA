package dp2;

public class Main {

	public static void main(String[] args) {

		// 학생
		Student minsu = new Student("minsu");
		Student gildong = new Student("gildong");
		Student kyuheon = new Student("kyuheon");
		// 강의
		Course java = new Course("java");
		Course cplus = new Course("C/C++");
		Course jsp = new Course("JSP");
		
		Transcript ts1 = new Transcript(jsp, minsu, "7/15", "97");
		
		minsu.registerTranscript(ts1);
		
		System.out.println(minsu);
		
	}

}
