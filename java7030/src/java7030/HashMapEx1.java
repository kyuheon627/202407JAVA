package java7030;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapEx1 {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();
		map.put("신용권", 85);
		map.put("신용권", 85);
		map.put("신용권", 90);
		map.put("동장군", 80);
		map.put("홍길동", 100);
		System.out.println(map.size());
		System.out.println(map.get("신용권"));
		System.out.println("-----------------------------");
		
		Set<String> keySet = map.keySet();
		for(String str : keySet) {
			System.out.println(str);
			System.out.println(map.get(str));
		}
		System.out.println("-----------------------------");
		
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		for(Map.Entry<String, Integer> kv : entrySet) {
			String k = kv.getKey();
			Integer v = kv.getValue();
			String msg = MessageFormat.format("{0}, {1}", k, v);
			System.out.println(msg);
		}
	}

}
