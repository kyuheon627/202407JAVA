package java0716;

public class ColorPoint extends Point{

	public ColorPoint() {
		super(100, 200);
		System.out.println("자식 상속자 ColorPoint 실행");
		System.out.println(x);
		method1();
	}

	public ColorPoint(int x, int y) {
		super(x, y);
	}

	@Override
	void method1() {
		super.method1();
		System.out.println("자식이 오버라이딩!");
	}
	
	

}
