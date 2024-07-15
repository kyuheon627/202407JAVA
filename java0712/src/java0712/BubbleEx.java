package java0712;

public class BubbleEx {

	public static void main(String[] args) {

		int a[]	= {10, 3, 1, 4, 2};
		
		for(int i=0; i<a.length-1; i++) {
			for(int j=a.length-1; j>i; j--) {
				if(a[j] < a[j-1]) {
					//swap
					int tmp = a[j];
					a[j] = a[j-1];
					a[j-1] = tmp;
				}
			}
		}
//		for(int i=0; i<a.length; i++) {
//			System.out.print(a[i]+"	");
//		}
		
		for(int n : a) {	// for-each (향상된 for문)
			System.out.println(n);
		}
	}

}
