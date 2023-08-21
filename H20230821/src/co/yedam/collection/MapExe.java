package co.yedam.collection;

import java.util.HashMap;
import java.util.Map;

public class MapExe {
	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<>();
		
		map.put("홍길동", 80);
		map.put("김길동", 85);
		map.put("박길동", 90);
		
		Integer val = map.get("홍길동");
		System.out.println(val);
		
	}
}

class USer {
	
	private String id;
	
	private String pw;
	
}
