package co.yedam.clazz.calendar;

import java.util.Scanner;

public class CalendarExe {
	
	static Scanner sc = new Scanner(System.in);
	
	static CalendarApp app = new CalendarApp();
	

	public static void main(String[] args) {
		
		boolean run = true;
		
		while (run) {
			
			System.out.println("날짜정보('YYYY/MM')를 입력하세요(종료:'0/0')");
			String[] data = sc.nextLine().split("/");
			
			int year = Integer.parseInt(data[0]);
			int month = Integer.parseInt(data[1]);
			
			if (year == 0 || month == 0) {
				run = false;
				break;
			}
			
			app.showClaendar(year , month);
			
		}
		
		System.out.println("CalendarApp을 종료합니다.");
		
	}
	
}

