package co.yedam;

public class Friend {
	
	String name;
	
	String phone;
	
	Gender gender;
	
	
	void showInfo() {
		System.out.printf("이름 : %s, 연락처 : %s, 성별 : %s\n",
				this.name, 
				this.phone,
				this.gender == Gender.MEN ? "남자" : "여자");
	}
	
	void briefInfo() {
		System.out.printf("이름 : %s, 연락처 : %s\n", this.name, this.phone);
	}
	
	
	static Friend createFriend(String name, String phone, int genNum) {
		
		Friend friend = new Friend();
		
		friend.name = name;
		friend.phone = phone;
		if (genNum == 1) {
			friend.gender = Gender.MEN;
		} else if (genNum == 2) {
			friend.gender = Gender.WOMEN;
		} else {
			friend.gender = null;
		}
		
		return friend;
		
	}
	
}
