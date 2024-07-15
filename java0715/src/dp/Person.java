package dp;

public class Person {

	private Phone[] phones;
	
	public Person(){
		phones = new Phone[2];
	}
	
	// 좋지 못한 설계
	public Phone getPhone(int i) {
		if(i == 0 || i == 1) {
			return phones[i];	// 0일 때는 집전화, 1일 때는 회사 전화
		}
		return null;
	}
}
