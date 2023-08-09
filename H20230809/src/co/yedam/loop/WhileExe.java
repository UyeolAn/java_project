package co.yedam.loop;

public class WhileExe {
	public static void main(String[] args) {
		
		boolean run = true;
		
		while (run) {
			
			int tmp = (int) (Math.random() * 100);
			System.out.println(tmp);
			
			if (tmp > 90) {
				run = false;
			}
			
		}
		
		System.out.println("end");
		
	}
}
