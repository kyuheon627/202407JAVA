package java7030;

import java.util.Arrays;
import java.util.List;

public class Ex4 {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("Aaa", "Bbb", "Ccc");
		list.forEach(System.out::println);
		
	}

}
