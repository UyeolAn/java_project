package co.yedam.collection;

import java.util.ArrayList;

public class MemberListExe {
	public static void main(String[] args) {
		
		ArrayList<Member> memberList = new ArrayList<Member>();
		
		memberList.add(new Member(1001, "우열"));
		
		Member member = new Member(1002, "승호");
		memberList.add(member);
		
		for (Member m : memberList) {	
			if (m.getMemberId() == 1001) {
				m.setMemberName("안우열");
			}
		}
		
		for (Member m : memberList) {
			System.out.printf("이름은 %s 입니다.\n", m.getMemberName());
		}
		
	}
}
