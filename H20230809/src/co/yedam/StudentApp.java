package co.yedam;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {
		
		Student[] students = new Student[10];
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int idx = 0;
		
		//1.등록 2.조회 3.목록
		while (run) {
			
			System.out.println("\n메뉴를 선택하세요(1.둥록 2.조회 3.목록 4.종료)");
			
			int menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
				case 1:
					System.out.println("학생 등록입니다.");
					
					System.out.println("학생 이름을 입력하세요 : ");
					String stdName = sc.nextLine();
					System.out.println("학생 점수를 입력하세요 : ");
					int stdScore = Integer.parseInt(sc.nextLine());
					
					Student std = new Student();
					std.name = stdName;
					std.score = stdScore;
					
					students[idx++] = std;
					
					System.out.println("등록이 완료되었습니다.");
					break;
				case 2:
					System.out.println("학생 점수 조회입니다.");
					
					System.out.println("학생 이름을 입력하세요 : ");
					String targetName = sc.nextLine();
					
					for (int i = 0; i < idx; i++) {
						if (students[i].name.equals(targetName)) {
							System.out.printf(
									"'%s'학생의 점수는 %d점 입니다.\n", 
									students[i].name, students[i].score);
							break;
						}
					}
					break;
				case 3:
					System.out.println("학생 목록 조회입니다.");
					System.out.println("===========================");
					
					for (int i = 0; i < idx; i++) {
						System.out.printf(
								"학생%d. 이름 : %s, 점수 : %d\n", 
								i+1, students[i].name, students[i].score);
					}
					
					System.out.println("===========================");
					break;
				case 4:
					System.out.println("프로그램을 종료합니다.");
					run = false;
					break;
				default:
					System.out.println("번호를 다시 입력해주세요.");
					break;
			
			}
		}
	}
}

class Student {
	String name;
	int score;
}
