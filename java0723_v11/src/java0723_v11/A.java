package java0723_v11;

public class A {
	int field1;
	void method1() {}
	
	static int field2;
	static void method2() {}
	
	class B{
		void methodB() {
//			this.field1 = 20;
			field1 = 10;
//			this.method1();
			method1();
			
			field2 = 10;
//			this.method2();
			method2();
		}
	}
	
	static class C{
		void methodC() {
//			field1 = 10;
//			method1();
			
			field2 = 10;
//			this.method2();
			method2();
		}
	}
	
	private class D{
		void methodD() {
//			this.field1 = 20;
			field1 = 10;
//			this.method1();
			method1();
			
			field2 = 10;
//			this.method2();
			method2();
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(A.field2);
//		System.out.println(field1);
		A a = new A();
		System.out.println(a.field1);
		
		A.B b = a.new B();
		b.methodB();
		
		A.C c = new A.C();
		c.methodC();
		
		A.D d = a.new D();
		d.methodD();
	}
}
