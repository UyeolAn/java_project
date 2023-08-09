package co.yedam.loop;

public class LoopPs {
	public static void main(String[] args) {
		
		//문제 2
		System.out.println("\n문제 2");
		
		int sum = 0;
		for (int i = 3; i <= 100; i += 3) {
			sum += i;
		}
		
		System.out.println(sum);
		
		
		//문제 3
		System.out.println("\n문제 3");
		
		boolean run = true;
		
		while (run) {
			
			int dice1 = (int) (Math.random() * 6) + 1;
			int dice2 = (int) (Math.random() * 6) + 1;
			System.out.printf("(%d, %d)\n", dice1, dice2);
			
			if (dice1 + dice2 == 5) {
				run = false;
			}
			
		}
		
		
		//문제 4
		System.out.println("\n문제 4");
		
		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				if (4*x + 5*y == 60) {
					System.out.printf("(%d, %d)\n", x, y);
				}
			}
		}
		
		
		//문제 5
		System.out.println("\n문제 5");
		
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		//문제 6
		System.out.println("\n문제 6");
		
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4-i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
}
