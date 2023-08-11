package co.yedam.clazz.friend;

import java.util.Scanner;

public class FriendApp {

	Scanner sc = new Scanner(System.in);
	
	Friend[] friends = new Friend[10];
	
	static void start() {
		
		FriendApp app = new FriendApp();
		
		Scanner scn = app.sc;
		
		boolean run = true;
		
		while (run) {
			System.out.println("-----------------------------------------");
			System.out.println("1.등록 2.목록 3.조회(이름) 4.수정 5.삭제 9.종료");
			System.out.println("-----------------------------------------");
			int menu = Integer.parseInt(scn.nextLine());
			
			switch (menu) {
			
				case Menu.ADD:
					app.addFriend();
					break;
				case Menu.SHOW:
					app.showFriends();
					break;
				case Menu.SEARCH:
					app.findFriend();
					break;
				case Menu.EDIT:
					app.editFriend();
					break;
				case Menu.DEL:
					app.deleteFriend();
					break;
				case Menu.EXIT:
					System.out.println("프로그램을 종료합니다.");
					run = false;
					break;
				default:
					System.out.println("번호를 다시 입력해주세요.");
			}
			System.out.print("\n\n\n");
		}
	}

	void addFriend() {
		
		System.out.println("친구 추가 입니다.");
		System.out.println("정보(이름 연락처 생년월일)를 입력하세요 : ");
		String[] fdData = sc.nextLine().split(" ");
		
		Friend friend = new Friend(fdData[0], fdData[1], fdData[2]);
		
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] == null) {
				friends[i] = friend;
				break;
			}
		}
		
		System.out.println("추가가 완료되었습니다.");
		
	}
	
	void showFriends() {
		System.out.println("==================================================================");
		System.out.println("친구목록");
		System.out.println("==================================================================");
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null) {
				System.out.println(friends[i].toString());
			}
		}
		System.out.println("==================================================================");
		
	}
	
	void findFriend() {
		
		System.out.println("친구 조회 입니다.");
		System.out.println("조회할 친구의 이름을 입력하세요 : ");
		String targetName = sc.nextLine();
		boolean isExist = false;
		
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && friends[i].getName().equals(targetName)) {
				System.out.printf(
						"'%s'의 전화번호는 %s 이며 생일은 %s 입니다.\n",
						friends[i].getName(), friends[i].getPhone(), friends[i].getBirth());
				isExist = true;
				break;
			}
		}
		
		if (isExist == false) {
			System.out.println("해당 이름은 등록되지 않았습니다.");
		}
		
	}
	
	void editFriend() {
		
		System.out.println("친구 수정 입니다.");
		System.out.println("수정할 친구의 이름을 입력하세요 : ");
		String targetName = sc.nextLine();
		boolean isExist = false;
		
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && friends[i].getName().equals(targetName)) {
				System.out.println("수정정보(이름 연락처 생년월일)를 입력하세요 : ");
				String[] fdData = sc.nextLine().split(" ");
				friends[i] = new Friend(fdData[0], fdData[1], fdData[2]);
				isExist = true;
				break;
			}
		}
		
		if (isExist == false) {
			System.out.println("해당 이름은 등록되지 않았습니다.");
		}
		
		System.out.println("수정이 완료되었습니다.");
		
	}
	
	void deleteFriend() {
		
		System.out.println("친구 삭제 입니다.");
		System.out.println("삭제할 친구의 이름을 입력하세요 : ");
		String targetName = sc.nextLine();
		boolean isExist = false;
		
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null && friends[i].getName().equals(targetName)) {
				friends[i] = null;
				isExist = true;
				break;
			}
		}
		
		if (isExist == false) {
			System.out.println("해당 이름은 등록되지 않았습니다.");
		}
		
		System.out.println("삭제가 완료되었습니다.");
		
	}
}
