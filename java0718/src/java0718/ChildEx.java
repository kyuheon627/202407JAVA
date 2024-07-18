package java0718;

public class ChildEx {

	public static void main(String[] args) {

		Parent parent = new Child();
		
		anyMethod(parent);
		
		// 권장하지 않음
//		Child child = (Child) parent;
//		child.method3();
		
		// 권장하는 방법
		if(parent instanceof Child) {
			System.out.println("강제 타입 변환");
			Child child = (Child) parent;	// 강제 형변환을 해줘야함
			child.method3();
		}else {
			System.out.println("강제 형변환 불가능");
		}
		
	}

	public static void anyMethod(Parent parent) {
		parent.method2();
	}
	
}
