package co.yedam.condition;

public class SwitchExe {
	public static void main(String[] args) {
		
		int score = (int) (Math.random() * 100) + 1;
		String grade = "";
		
		int scoreCase = (score-1) / 10;
		
		switch (scoreCase) {
			case 9:
				grade = "A";
				break;
			case 8:
				grade = "B";
				break;
			case 7:
				grade = "C";
				break;
			case 6:
				grade = "D";
				break;
			default:
				grade = "F";
		}
		
		System.out.printf("점수 %d는, %s입니다.\n", score, grade);
		
	}
}
