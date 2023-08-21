package co.yedam.generic;

public class Main {
	public static void main(String[] args) {
		
		Box<String> box = new Box<>();
		
		box.set("Hello"); 
		String result = box.get();
		
		Box<Integer> ibox = new Box<>();
		
		ibox.set(10);
		Integer iresult = ibox.get();
		
	}
}
