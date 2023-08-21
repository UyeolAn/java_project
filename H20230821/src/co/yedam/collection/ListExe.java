package co.yedam.collection;

import java.util.ArrayList;
import java.util.List;

public class ListExe {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();

		list.add("Hello");
		list.add(new String("World"));
		list.add("Good");

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
		list.set(1, "Result");
		
		System.out.println("=====수정후=====");
		
		for (String str : list) {
			System.out.println(str);
		}
		
		
		list.remove(1);
		
		System.out.println("=====삭제후=====");
		
		for (String str : list) {
			System.out.println(str);
		}
		
		
		list.clear();
		
		System.out.println("=====전체 삭제후=====");
		
		for (String str : list) {
			System.out.println(str);
		}

	}

}
