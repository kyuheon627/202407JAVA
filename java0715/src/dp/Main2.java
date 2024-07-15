package dp;

public class Main2 {

	public static void main(String[] args) {
		
		Student minsu = new Student("민수", "001");
		Course java = new Course("cs101", "자바");
		Course cpuls = new Course("cs102", "C/C++");
		minsu.registerCourse(java);
		minsu.registerCourse(cpuls);
		
		Student gildong = new Student("길동", "002");
		gildong.registerCourse(java);
		
		System.out.println(minsu);
		System.out.println(gildong);
		
		// 코스별 신청자 출력
		System.out.println(java.getStudents());
	}

}
