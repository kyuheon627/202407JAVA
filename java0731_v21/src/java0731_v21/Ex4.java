package java0731_v21;

public class Ex4 {

	public static void main(String[] args) {

		char grade = 'B';
		
		int ret = switch(grade) {
			case 'A', 'a' -> {
				yield 100;
			}
			case 'B', 'b' -> {
				yield 80;
			}
			default -> {
				yield 60;
			}
		};
		
	}

}
