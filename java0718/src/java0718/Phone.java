package java0718;

public abstract class Phone {

	String name;
	
	void turnOn() {
		System.out.println("폰 켜기");
	}

	abstract void turnOff();	// 추성 메소드를 생성하면 자식 클래스에 오버라이드를 해야됨
}
