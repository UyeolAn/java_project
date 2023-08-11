package co.yedam.clazz.student;

public class Student {

	private int stdNo;
	
	private String stdName;
	
	private int score;
	

	public Student() {
		
	}
	
	public Student(int stdNo, String name, int score) {
		
		this.stdNo = stdNo;
		this.stdName = name;
		
		if (score < 0 || score > 100) {
			System.out.println("잘못된 점수이므로 0점으로 초기화됩니다.");
			this.score = 0;
		} else {
			this.score = score;
		}
		
	}
	
	public int getStdNo() {
		return this.stdNo;
	}
	
	public void setStdNo(int stdNo) {
		this.stdNo = stdNo;
	}
	
	public String getStdName() {
		return this.stdName;
	}
	
	public void setStdName(String name) {
		this.stdName = name;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int score) {
		if (score < 0 || score > 100) {
			System.out.println("잘못된 점수이므로 0점으로 초기화됩니다.");
			this.score = 0;
		} else {
			this.score = score;
		}
	}
	
	
	public void stdInfo() {
		System.out.printf(
				"학번 : %d, 학생이름 : %s, 점수 : %d\n",
				this.stdNo, this.stdName, this.score);
	}
	
}
