package co.yedam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		
		Date today = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		System.out.println(today.toString());
		System.out.println(sdf.format(today));
		
		String strTime = "2023-09-01 13:22:33";
		
		try {
			Date newDate = sdf.parse(strTime);
			System.out.println(newDate.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		
	}
}
