package co.yedam.collection;

import java.util.LinkedList;
import java.util.Queue;

// Queue : FIFO(First In First Out)
public class QueueExe {
	public static void main(String[] args) {
		
		Queue<String> queue = new LinkedList<>();
		
		queue.offer("One");
		queue.offer("Two");
		queue.offer("Three");
		
		while (!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		
	}
}
