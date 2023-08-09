package co.yedam.condition;

public class ConditionPs {
	public static void main(String[] args) {
		
		int num = (int) (Math.random() * 3) + 1;
		System.out.println(num);
		
		switch (num) {
			case 1:
				System.out.println("가위 입니다.");
				break;
			case 2:
				System.out.println("바위 입니다.");
				break;
			case 3:
				System.out.println("보 입니다.");
				break;
			default:
				System.out.println("잘못된 값입니다.");
		}
		
		
		char grade = (char) ((int) (Math.random() * 4) + 65);
		
		switch (grade) {
			case 'A': 
				System.out.println("VVIP 혜택을 받으실 수 있습니다.");
			case 'B': 
				System.out.println("VIP 혜택을 받으실 수 있습니다."); 
				break;
			case 'C': 
				System.out.println("우수 회원 혜택을 받으실 수 있습니다.");
			case 'D': 
				System.out.println("일반 회원 혜택을 받으실 수 있습니다."); 
				break;
			default: 
				System.out.println("혜택이 없습니다.");
		}
		
	}
}
