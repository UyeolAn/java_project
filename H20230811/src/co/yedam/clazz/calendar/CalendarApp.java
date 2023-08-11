package co.yedam.clazz.calendar;

import java.util.Calendar;

public class CalendarApp {
	
	public void showClaendar(int year, int month) {
		
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, 1);
		
		System.out.println("============================");
		System.out.printf("%4d년%3d월\n", year, month);
		System.out.println("============================");
		
		String[] days = {"Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat"};
		for (int i = 0; i < days.length; i++) {
			System.out.printf("%4s", days[i]);
		}
		System.out.println();
		
		int space = cal.get(Calendar.DAY_OF_WEEK) - 1;
		for (int i = 0; i < space; i++) {
			System.out.printf("%4s", " ");
		}
		
		for (int i = 1; i <= cal.getActualMaximum(Calendar.DATE); i++) {
			System.out.printf("%4d", i);
			if ((i + space) % 7 == 0) {
				System.out.println();
			}
		}
		
		System.out.print("\n\n\n");
		
	}

}
