package java0725;

import java.util.HashMap;

public class KeyEx {

	public static void main(String[] args) {

//		HashMap<Integer, String> hashmap = new HashMap<>();
//		
//		hashmap.put(1, "홍길동");
//		hashmap.put(2, "강하나");
//		
//		String value = hashmap.get(2);
//		System.out.println(value);
		
		Key key1 = new Key(100);
		Key key2 = new Key(100);
		System.out.println(key1.hashCode());
		System.out.println(key2.hashCode());
		if(key1.equals(key2)) {
			System.out.println("같다.");
		}
		
		HashMap<Key, String> hashmap = new HashMap<>();
		
		hashmap.put(new Key(1), "홍길동");
		
		String value = hashmap.get(new Key(1));
		System.out.println(value);
	}

}
