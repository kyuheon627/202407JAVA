package project1;

public class Ex2 {

	public static void main(String[] args) {
		
		Member mb = null;
		Member[] list = {
				new Member("강하나", "911224", "010-1234-1234"),
				new Member("강두리", "940110", "010-1234-1234"),
				new Member("강세리", "990601", "010-1234-1234")
		};
		
		for(Member member : list) {
			System.out.println(member);
		}
		int find = -1;	// 찾기 전 또는 못찾았을 때
		
//		for(int i=0; i<list.length; i++) {
//			if(list[i].userName.equals("강하나")) {
//				find = i;
//				mb = list[i];
//				break;
//			}
//		}
		System.out.println("인덱스:" + find);
		System.out.println(mb);
	}

}
