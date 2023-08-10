package co.yedam;

import java.util.Arrays;
import java.util.Scanner;

public class ScoreApp {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int studentNum = 0;
		Std[] students = new Std[10];
		boolean run = true;
		
		while (run) {
			
			System.out.println("----------------------------------------------");
			System.out.println("1.학생수 | 2.학생정보입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("----------------------------------------------");
			System.out.println("메뉴를 선택하세요 : ");
			
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
				case 1:
					System.out.printf("학생 수는 %d명 입니다.\n", studentNum);
					break;
				case 2:
					System.out.println("학생 정보를 입력하세요('이름, 점수') : ");
					String[] stdData = sc.nextLine().split(", ");
					
					Std std = new Std();
					std.name = stdData[0];
					std.score = Integer.parseInt(stdData[1]);
					
					students[studentNum++] = std;
					System.out.println("입력이 완료되었습니다.");
					break;
				case 3:
					for (int i = 0; i < studentNum; i++) {
						System.out.printf(
								"학생 %d. 이름 : %s, 점수 : %d\n", 
								i, students[i].name, students[i].score);
					}
					break;
				case 4:
					int maxScore = students[0].score;
					int maxScoreIdx = 0;
					int sumScore = students[0].score;
					double avgScore;
					
					for (int i = 1; i < studentNum; i++) {
						sumScore += students[i].score;
						if (students[i].score > maxScore) {
							maxScore = students[i].score;
						}
					}
					
					avgScore = (double) sumScore / studentNum;
					
					System.out.printf(
							"최고점을 받은 학생은 '%s'학생이며 점수는 %d점 입니다\n",
							students[maxScoreIdx].name, students[maxScoreIdx].score);
					System.out.printf("평균 점수는 %.2f점 입니다\n", avgScore);
					break;
				case 5:
					System.out.println("프로그램 종료");
					run = false;
					break;
				default:
					
			}
		}
	}
}

class Std {
	String name;
	int score;
}
