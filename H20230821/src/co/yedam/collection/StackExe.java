package co.yedam.collection;

import java.util.Stack;

// Stack : LIFO(Last In First Out)
public class StackExe {
	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<>();
		
		stack.push("One");
		stack.push("Two");
		stack.push("Three");
		
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
	}
}
