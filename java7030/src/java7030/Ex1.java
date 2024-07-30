package java7030;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class Ex1 {

	public static void main(String[] args) {

		List<Student> list = new ArrayList<>();
		list.add(new Student("Ken", 100));
		list.add(new Student("Shin", 60));
		list.add(new Student("Kim", 80));
		
		
		long num = list.stream().filter(s->s.getScore() >= 70).count();
		System.out.println("70점 이상은 " + num + "명");
		
		// 람다식을 이용
		list.stream()	// 스트림
		.filter(s->s.getScore() >= 70)	// 중간 작업
		.forEach(s->System.out.println(s.getName()));	// 최종 작업
		
//		// 문제1. 점수가 70점 미만인 사람은 리스트에서 삭제해 보세요.
//		for(int i=0; i<list.size(); i++) {
//			if(list.get(1).getScore() < 70) {
//				list.remove(i);
//			}
//		}
		
		list.stream().forEach(a->{
			String msg = MessageFormat.format("{0}, {1}", a.getName(), a.getScore());
			System.out.println(msg);
		});
		
//		for(Student st : list) {
//			String msg = MessageFormat.format("{0}, {1}", st.getName(), st.getScore());
//			System.out.println(msg);
//		}
	}

}
