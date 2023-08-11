package co.yedam;

import java.util.Scanner;

public class TodoApp {
	
	static Scanner sc = new Scanner(System.in);
	
	static Todo[] todoList = new Todo[10];
	static int tdIdx = 0;
	
	public static void main(String[] args) {
		
		boolean run = true;
		
		while (run) {
			
			System.out.println("---------------------------------------------");
			System.out.println("1.등록 | 2.완료처리 | 3.조회 | 4.미완료목록 | 5.종료");
			System.out.println("---------------------------------------------");
			System.out.println("메뉴를 선택하세요 : ");
			
			String menu = sc.nextLine();
			
			switch (menu) {
			
				case "1":
					addTodo(); //할일 등록
					break;
				case "2":
					doneTodo(); //할일 완료처리
					break;
				case "3":
					searchTodo(); //할일 조회
					break;
				case "4":
					searchNotDoneTodo(); //미완료목록 조회
					break;
				case "5":
					run = false;
					break;
				default:
					System.out.println("메뉴를 다시 선택하세요.");
					
			}
			
			System.out.print("\n\n\n");
			
		}
		
		System.out.println("프로그램을 종료합니다.");
		sc.close();
		
	}

	static void addTodo() {
		
		System.out.println("할일(Todo) 등록입니다.");
		System.out.println("번호, 할일, 날짜를 입력하세요 : ");
		String[] todoData = sc.nextLine().split(" ");
		
		Todo td = new Todo();
		td.no = Integer.parseInt(todoData[0]);
		td.todo = todoData[1];
		td.dueDate = todoData[2];
		td.done = false;
		
		todoList[tdIdx++] = td;
		
		System.out.println("등록을 완료하였습니다.");
		
	}
	
	static void doneTodo() {
		
		System.out.println("할일(Todo) 완료처리입니다.");
		System.out.println("번호를 입력하세요(여러 개 입력 가능) : ");
		
		//할일 번호(No) 추출
		String[] tdNumData = sc.nextLine().split(" ");
		
		//각 번호를 탐색하면서 조회
		for (String nd : tdNumData) {
			int num = Integer.parseInt(nd);
			for (int i = 0; i < tdIdx; i++) {
				if (todoList[i].no == num) {
					todoList[i].done = true;
					System.out.printf("'%s'이(가) 완료처리 되었습니다.\n", todoList[i].todo);
				}
			}
		}
		
	}
	
	static void searchTodo() {
		
		System.out.println("할일(Todo) 조회입니다.");
		System.out.println("번호를 입력하세요(여러 개 입력 가능) : ");
		
		//할일 번호(No) 추출
		String[] tdNumData = sc.nextLine().split(" ");
		
		//할일 번호(No) 정렬
		int[] tdNum = new int[tdNumData.length];
		for (int i = 0; i < tdNum.length; i++) {
			tdNum[i] = Integer.parseInt(tdNumData[i]);
		}
		sortArray(tdNum);
		
		//정렬된 순서로 조회
		System.out.println("조회 결과");
		System.out.println("==========================================");
		for (int i = 0; i < tdNum.length; i++) {
			for (int j = 0; j < tdIdx; j++) {
				if (todoList[j].no == tdNum[i]) {
					System.out.printf(
							"No.%d 할일 : %s, 날짜 : %s, 상태 : %s\n", 
							todoList[j].no, todoList[j].todo, todoList[j].dueDate,
							todoList[j].done == true ? "완료" : "미완료");
				}
			}
		}
		System.out.println("==========================================");
		
	}
	
	public static void sortArray(int[] array) {
			
		for (int i = array.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					int tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
				}
			}
		}
	
	}

	static void searchNotDoneTodo() {
		
		System.out.println("미완료목록 조회입니다.");
		System.out.println("================================");
		for (int i = 0; i < tdIdx; i++) {
			if (todoList[i].done == false) {
				System.out.printf(
						"No.%d 할일 : %s, 날짜 : %s\n", 
						todoList[i].no, todoList[i].todo, todoList[i].dueDate);
			}
		}
		System.out.println("================================");
		
	}
	
}
