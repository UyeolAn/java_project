package co.yedam.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExe {
	public static void main(String[] args) {
		
		// ArrayList : 끝에 추가하는 속도가 상대적으로 빠름
		//			   반면에 특정 인덱스에 추가하는 속도는 느림
		List<String> aList = new ArrayList<>();
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			aList.add(0, "" + i);
		}
		long end = System.currentTimeMillis();
		
		System.out.println((end - start) + "ms");
		
		
		// LinkedList : 추가 속도가 상대적으로 느림
		//	            반면에 특정 인덱스에 추가하는 속도는 빠름
		List<String> lList = new LinkedList<>();
		
		start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			lList.add(0, "" + i);
		}
		end = System.currentTimeMillis();
		
		System.out.println((end - start) + "ms");
		
	}
}
