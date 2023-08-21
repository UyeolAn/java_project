package co.yedam.friend;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileScanTest {
	public static void main(String[] args) {
		
		File file = new File("src/co/yedam/friend/friends.txt");
		
		List<Friend> friends = new ArrayList<>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일을 찾을 수 없습니다.");
			return;
		}
		
		while (true) {
			try {
				String line = sc.nextLine();
				String[] data = line.split(" ");
				try {
					friends.add(new Friend(data[0], data[1], sdf.parse(data[2])));
				} catch (ParseException e) {
					System.out.println("잘못된 날짜 정보가 들어있습니다.");
					return;
				}
			} catch (NoSuchElementException e) {
				break;
			}
		}
		
		for (Friend f : friends) {
			System.out.println(f);
		}
		
		sc.close();
		
	}
}
