package co.yedam;

public class CalanderApp {
	public static void main(String[] args) {
		
		for (int month = 1; month <= 12; month++) {
			
			System.out.println("============================");
			System.out.printf("%4d월\n", month);
			System.out.println("============================");
			
			String[] days = {"Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat"};
			for (int i = 0; i < days.length; i++) {
				System.out.printf("%4s", days[i]);
			}
			System.out.println();
			
			int space = getFirstDay(month);
			for (int i = 0; i < space; i++) {
				System.out.printf("%4s", " ");
			}
			
			for (int i = 1; i <= getDays(month); i++) {
				System.out.printf("%4d", i);
				if ((i + space) % 7 == 0) {
					System.out.println();
				}
			}
			
			System.out.print("\n\n\n");
			
		}
		
	}
	
	public static int getFirstDay(int month) {
		
		int day230101 = 0;
		int sumDate = 0;
		
		for (int i = 1; i <= 12; i++) {
			if (i == month) {
				return (day230101 + sumDate) % 7;
			} 
			sumDate += getDays(i);
		}
		
		return -1;
		
	}
	
	public static int getDays(int month) {
		switch (month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				return 31;
			case 4: case 6: case 9: case 11:
				return 30;
			case 2:
				return 28;
			default:
				return -1;
		}
	}
}
