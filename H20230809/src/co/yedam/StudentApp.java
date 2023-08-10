package co.yedam;

import java.util.Scanner;

public class StudentApp {
	public static void main(String[] args) {
		
		Student[] students = new Student[10];
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		int idx = 0;
		
		while (run) {
			
			System.out.println("\n메뉴를 선택하세요(1.둥록 2.점수조회 3.목록 4.키큰학생 5.종료)");
			
			String menu = sc.nextLine();
			
			switch (menu) {
			
				case "1":
					System.out.println("학생 등록입니다.");
					
					System.out.println("학생 이름을 입력하세요 : ");
					String stdName = sc.nextLine();
					System.out.println("학생 점수를 입력하세요 : ");
					int stdScore = Integer.parseInt(sc.nextLine());
					System.out.println("학생 키를 입력하세요 : ");
					double stdHeight = Double.parseDouble(sc.nextLine());
					
					Student std = new Student();
					std.name = stdName;
					std.score = stdScore;
					std.height = stdHeight;
					
					students[idx++] = std;
					
					System.out.println("등록이 완료되었습니다.");
					break;
					
				case "2":
					System.out.println("학생 점수 조회입니다.");
					
					System.out.println("학생 이름을 입력하세요 : ");
					String targetName = sc.nextLine();
					
					boolean isRegistStd = false; //등록된 학생인지
					
					for (int i = 0; i < idx; i++) {
						if (students[i].name.equals(targetName)) {
							System.out.printf(
									"'%s'학생의 점수는 %d점 입니다.\n", 
									students[i].name, students[i].score);
							isRegistStd = true;
							break;
						}
					}
					
					if (isRegistStd == false) {
						System.out.println("등록되지 않은 학생입니다.");
					}
					
					break;
					
				case "3":
					System.out.println("학생 목록 조회입니다.");
					System.out.println("========================================");
					
					for (int i = 0; i < idx; i++) {
						System.out.printf(
								"학생%d. 이름 : %s, 점수 : %d, 키 : %.1fcm\n", 
								i+1, students[i].name, students[i].score, students[i].height);
					}
					
					System.out.println("========================================");
					break;
					
				case "4":
					double maxHeight = students[0].height;
					int maxHidx = 0;
					for (int i = 1; i < idx; i++) {
						if (students[i].height > maxHeight) {
							maxHeight = students[i].height;
							maxHidx = i;
						}
					}
					
					System.out.printf(
							"키가 가장 큰 학생은 '%s'학생이며 키는 %.1fcm 입니다\n",
							students[maxHidx].name, students[maxHidx].height);
					break;
					
				case "5":
					System.out.println("프로그램을 종료합니다.");
					run = false;
					break;
					
				default:
					System.out.println("번호를 다시 입력해주세요.");
					break;
			
			}
		}
		sc.close();
	}
}
