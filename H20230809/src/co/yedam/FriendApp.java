package co.yedam;

import java.util.Scanner;

public class FriendApp {
	
	static Scanner sc = new Scanner(System.in);
	
	static Friend[] friends = new Friend[10];
	
	static int idx = 0;
	
	
	public static void main(String[] args) {
		
		boolean run = true;
		
		while (run) {
			
			System.out.println("메뉴를 선택하세요(1.추가, 2.수정, 3.삭제, 4.조회, 5.목록, 6.종료)");
			String menu = sc.nextLine();
			
			switch (menu) {
			
				case "1":
					addFriend(); //친추 추가
					break;
				case "2":
					modifyFriend(); //친구 연락처 수정
					break;
				case "3":
					deleteFriend(); //친구 삭제
					break;
				case "4":
					showFriendInfo(); //친구 조회
					break;
				case "5":
					showFriends(); //친구목록 조회
					break;
				case "6":
					System.out.println("프로그램을 종료합니다.");
					run = false;
					break;
				default:
					System.out.println("메뉴를 다시 입력하세요.");
					break;
					
			}
			
			System.out.print("\n\n\n");
			
		}
		
		sc.close();
		
	}
	
	public static void addFriend() {
		
		System.out.println("친구추가 입니다.");
		
		System.out.println("이름을 입력하세요 : ");
		String fdName = sc.nextLine();
		System.out.println("핸드폰 번호를 입력하세요 : ");
		String fdPhone = sc.nextLine();
		System.out.println("성별을 입력하세요(1-남자, 2-여자) : ");
		int fdGenderNum = Integer.parseInt(sc.nextLine());
		
		Friend fd = Friend.createFriend(fdName, fdPhone, fdGenderNum);
		if (fd.gender == null) {
			System.out.println("성별을 잘못 입력하셨습니다.");
			return;
		}
		
		friends[idx++] = fd;
		System.out.println("친구추가가 완료되었습니다.");
		
	}
	
	public static void modifyFriend() {
		
		System.out.println("친구연락처 수정 입니다.");
		
		System.out.println("연락처를 수정할 친구의 이름을 입력하세요 : ");
		String targetName = sc.nextLine();
		
		boolean isRegisted = false;
		
		for (int i = 0; i < idx; i++) {
			if (friends[i].name.equals(targetName)) {
				System.out.println("바뀐 연락처를 입력해주세요 : ");
				String updatePhone = sc.nextLine();
				friends[i].phone = updatePhone;
				isRegisted = true;
				return;
			}
		}
		
		if (isRegisted == false) {
			System.out.println("등록되지 않은 이름입니다.");
		} else {
			System.out.println("수정이 완료되었습니다.");
		}
		
	}
	
	public static void deleteFriend() {
		
		System.out.println("친구삭제 입니다.");
		
		System.out.println("삭제할 친구의 이름을 입력하세요 : ");
		String targetName = sc.nextLine();
		
		boolean isRegisted = false;
		
		for (int i = 0; i < idx; i++) {
			if (friends[i].name.equals(targetName)) {
				for (int j = i; j < idx; j++) {
					friends[j] = friends[j+1];
				}
				friends[--idx] = null;
				isRegisted = true;
				break;	
			}
		}
		
		if (isRegisted == false) {
			System.out.println("등록되지 않은 이름입니다.");
		} else {
			System.out.println("삭제가 완료되었습니다.");
		}
		
	}
	
	public static void showFriendInfo() {
		
		System.out.println("친구조회 입니다.");
		
		System.out.println("조회할 친구의 이름을 입력하세요 : ");
		String targetName = sc.nextLine();
		
		boolean isRegisted = false;
		
		for (int i = 0; i < idx; i++) {
			if (friends[i].name.equals(targetName)) {
				friends[i].showInfo();
				isRegisted = true;
				break;
			}
		}
		
		if (isRegisted == false) {
			System.out.println("등록되지 않은 이름입니다.");
		}
		
	}
	
	public static void showFriends() {
		
		System.out.println("친구목록 입니다.");
		System.out.println("================================");
		
		for (int i = 0; i < idx; i++) {
			friends[i].briefInfo();
		}
		
		System.out.println("================================");
		
	}
	
	
}
