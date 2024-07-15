package java0712;

public class SearchEx {

	public static void main(String[] args) {

		int a[] = {10, 3, 4, 1, 7};
		int val = 4;
		int find = -1;	//찾기 전 또는 못찾았을 경우
		
		for(int i=0; i<a.length-1; i++) {
			if(a[i] == val) {
				find = i;
			}
		}
		System.out.println(find);
	}

}
