package co.yedam.condition;

public class IfExe {
	public static void main(String[] args) {
		
		int score = (int) (Math.random() * 100) + 1;
		String grade = "";
		
		if (score > 90) {
			grade = "A";
		} else if (score > 80) {
			grade = "B";
		} else if (score > 70) {
			grade = "C";
		} else if (score > 60) {
			grade = "D";
		} else {
			grade = "F";
		}
		
		System.out.printf("점수 %d는, %s입니다.\n", score, grade);
		
	}
}
