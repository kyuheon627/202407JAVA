package java0718;

public class InterEx {

	public static void main(String[] args) {

		InpleC inplec = new InpleC();
		
		InterA ia = inplec;
		ia.methodA();
		
		InterB ib = inplec;
		ib.methodB();
	}

}
