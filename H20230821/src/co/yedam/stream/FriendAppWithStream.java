package co.yedam.stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class FriendAppWithStream {
	
	private static Scanner sc = new Scanner(System.in);

	private static List<Friend> friendList = new ArrayList<>();
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
	
	private static File file = new File("src/co/yedam/stream/data.txt");
	
	
	public FriendAppWithStream() {
		loadFile();
	}
	
	
	public static void start() {
		
		FriendAppWithStream app = new FriendAppWithStream();
		
		boolean run = true;
		
		while (run) {
			
			System.out.println("---------------------------");
			System.out.println("1.등록 | 2.목록 | 3.저장 및 종료");
			System.out.println("---------------------------");
			System.out.println("번호 >>");
			
			int menu = sc.nextInt(); sc.nextLine();
			
			switch (menu) {
				case 1:
					app.addFriend();
					break;
				case 2:
					app.findAll();
					break;
				case 3:
					app.saveFile();
					run = false;
					break;
				default:
					System.out.println("없는 번호입니다.");
					System.out.println("번호를 다시 입력하세요.");
					break;
			}
			System.out.print("\n\n\n");
		}
		System.out.println("프로그램을 종료합니다.");
	}
	
	
	private void addFriend() {
		
		System.out.println("-------------");
		System.out.println("친구 등록입니다.");
		System.out.println("-------------");
		
		System.out.println("이름 >>");
		String name =  sc.nextLine();
		
		System.out.println("전화번호 >>");
		String phone =  sc.nextLine();
		
		System.out.println("날짜(yy-MM-dd) >>");
		
		try {
			Date birth = sdf.parse(sc.nextLine());
			friendList.add(new Friend(name, phone, birth));
			System.out.println("등록 성공!");
		} catch (ParseException e) {
			System.out.println("날짜를 잘못 입력하셨습니다.");
			System.out.println("등록 실패.");
		}
		
	}

	private void findAll() {
		
		System.out.println("-------------");
		System.out.println("친구 목록입니다.");
		System.out.println("-------------");
		
		System.out.println("-----------------------------------");
		for (Friend f : friendList) {
			System.out.println(f);
		}
		System.out.println("-----------------------------------");
		
	}
	
	private void loadFile() {
		
		System.out.println("데이터를 불러오는 중입니다..");
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null && line != "") {
				String[] data = line.split(" ");
				try {
					friendList.add(new Friend(data[0], data[1], sdf.parse(data[2])));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("데이터를 정상적으로 불러왔습니다.\n\n\n");
		
	}
	
	private void saveFile() {
		
		System.out.println("저장중입니다..");
		
		try {
			FileWriter fw = new FileWriter(file);
			for (Friend f : friendList) {
				fw.write(f.toString() + '\n');
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("저장을 완료하였습니다.");
		
	}
	
}
