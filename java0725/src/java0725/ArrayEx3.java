package java0725;

import java.util.Arrays;

public class ArrayEx3 {

	public static void main(String[] args) {

//		int[] array = {1,1,4,5,7,10,15,22,35,55};
		int[] array = {5,19,59,13,1,79,32};
		int found = Arrays.binarySearch(array, 1);
		System.out.println(found);
		
	}

}
