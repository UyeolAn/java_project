package co.yedam.array;

import java.util.Arrays;

public class ArrayPs {
	public static void main(String[] args) {
		
		//정수, 문자열 배열 활용
		String[] names = {"홍길동", "김길동", "박길동", "최길동"};
		int[] scores = {85, 98, 92, 75};
		
		String maxScoreName = "";
		int maxScore = scores[0];
		
		for (int i = 1; i < scores.length; i++) {
			if (scores[i] > maxScore) {
				maxScore = scores[i];
				maxScoreName = names[i];
			}
		}
		
		System.out.printf("학생들 중 성적이 가장 높은 학생 이름은 '%s'입니다.\n", maxScoreName);
		
		
		//객체 배열 활용
		Student[] students = new Student[4];
		
		for (int i = 0; i < 4; i++) {
			Student s = new Student();
			s.name = names[i];
			s.score = scores[i];
			students[i] = s;
		}
		
		maxScoreName = "";
		maxScore = students[0].score;
		
		for (int i = 1; i < students.length; i++) {
			if (students[i].score > maxScore) {
				maxScore = students[i].score;
				maxScoreName = students[i].name;
			}
		}
		
		System.out.println(Arrays.toString(students));
		System.out.printf("학생들 중 성적이 가장 높은 학생 이름은 '%s'입니다.\n", maxScoreName);
		
	}
}

class Student {
	String name;
	int score;
	
	@Override
	public String toString() {
		return "[name = " + name + " score = " + score + "]";
	}
}
