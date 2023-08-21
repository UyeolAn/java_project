package co.yedam.friend;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FriendApp {

	private static Scanner sc = new Scanner(System.in);
	
	private static List<Friend> friendList = new ArrayList<>();
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private Map<String, String> userInfo = new HashMap<>();
	
	
	public FriendApp() {
		this.userInfo.put("u10e822", "tnsmdeoqkr1!");
		this.userInfo.put("dksdnduf822", "dksdnduf9322");
		this.userInfo.put("yeoli.std@gmail.com", "Tnsmdeoqkr1!");
	}
	
	
	public static void start() {
		
		FriendApp app = new FriendApp();
		
		boolean run = true;
		
		while (!app.userCheck()) {
			System.out.print("\n\n\n");
		}
		
		while (run) {
			
			System.out.println("-----------------------------------------------");
			System.out.println("1.등록 | 2.목록 | 3.조회 | 4.수정 | 5.삭제 | 9.종료");
			System.out.println("-----------------------------------------------");
			System.out.println("번호 >>");
			
			try {
				
				int menu = Integer.parseInt(sc.nextLine());
				
				switch (menu) {
					case 1:
						app.addFriend();
						break;
					case 2:
						app.findAll();
						break;
					case 3:
						app.findFriendByName();
						break;
					case 4:
						app.updateFriend();
						break;
					case 5:
						app.deleteFriend();
						break;
					case 9:
						run = false;
						break;
					default:
						System.out.println("없는 번호입니다.");
						System.out.println("번호를 다시 입력하세요.");
						break;
				}
				
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하셔야 합니다.");
				System.out.println("번호를 다시 입력하세요.");
			}
			System.out.print("\n\n\n");
		}
		System.out.println("프로그램을 종료합니다.");
	}
	

	private boolean userCheck() {
		
		System.out.println("-----");
		System.out.println("로그인");
		System.out.println("-----");
		
		System.out.println("ID >>");
		String id = sc.nextLine();
		
		for (String key : this.userInfo.keySet()) {
			if (key.equals(id)) {
				System.out.println("pwd >>");
				String pwd = sc.nextLine();
				if (this.userInfo.get(key).equals(pwd)) {
					System.out.println("로그인 성공!\n\n\n");
					return true;
				} else {
					System.out.println("비밀번호가 틀렸습니다.");
					return false;
				}
			}
		}
		
		System.out.println("등록되지 않은 ID 입니다.");
		return false;
	
	}

	private void addFriend() {
		
		System.out.println("-------------");
		System.out.println("친구 등록입니다.");
		System.out.println("-------------");
		
		System.out.println("이름 >>");
		String name =  sc.nextLine();
		
		System.out.println("전화번호 >>");
		String phone =  sc.nextLine();
		
		System.out.println("날짜(yyyy-MM-dd) >>");
		
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
		
		System.out.println("-----------------------------------------------------");
		for (Friend f : friendList) {
			System.out.println(f);
		}
		System.out.println("-----------------------------------------------------");
		
	}

	private void findFriendByName() {
		
		System.out.println("-------------");
		System.out.println("친구 조회입니다.");
		System.out.println("-------------");
		
		System.out.println("이름 >>");
		
		String targetName = sc.nextLine();
		
		for (Friend f : friendList) {
			if (f.getName().equals(targetName)) {
				System.out.println("<<조회한 친구 정보>>");
				System.out.println(f);
				return;
			}
		}
		
		System.out.println("등록되지 않은 이름입니다.");

	}

	private void updateFriend() {
		
		System.out.println("-------------");
		System.out.println("친구 수정입니다.");
		System.out.println("-------------");
		
		System.out.println("이름 >>");
		
		String targetName = sc.nextLine();
		
		for (Friend f : friendList) {
			if (f.getName().equals(targetName)) {
				
				System.out.println("이름(수정) >>");
				String updateName = sc.nextLine();
				
				System.out.println("전화번호(수정) >>");
				String updatePhone = sc.nextLine();
				
				System.out.println("날짜(수정) >>");
				
				try {
					
					f.setBirth(sdf.parse(sc.nextLine()));
					f.setName(updateName);
					f.setPhone(updatePhone);
					
					System.out.println("수정 성공!");
					
				} catch (ParseException e) {
					System.out.println("날짜를 잘못 입력하셨습니다.");
					System.out.println("수정 실패.");
				}
				
				return;
				
			}
		}
		
		System.out.println("등록되지 않은 이름입니다.");
		System.out.println("수정 실패.");
		
	}

	private void deleteFriend() {
		
		System.out.println("-------------");
		System.out.println("친구 삭제입니다.");
		System.out.println("-------------");
		
		System.out.println("이름 >>");
		
		String targetName = sc.nextLine();
		
		for (Friend f : friendList) {
			if (f.getName().equals(targetName)) {
				friendList.remove(f);
				System.out.println("삭제 성공!");
				return;
			}
		}
		
		System.out.println("등록되지 않은 이름입니다.");
		System.out.println("삭제 실패");
		
	}
	
}
