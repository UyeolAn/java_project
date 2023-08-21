package co.yedam.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExe {
	public static void main(String[] args) {
		
		// set : 동일한 값은 한 번만 담김
		Set<String> set = new HashSet<>();
		
		set.add("홍길동");
		set.add("김길동");
		set.add("박길동");
		set.add("홍길동");
		
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()) {
			String val = iter.next();
			System.out.println(val);
		}
		
	}
}
