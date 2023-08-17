package co.yedam.board;

import java.util.Scanner;

public class BoardApp {

	private Scanner sc = new Scanner(System.in);
	
	private Board[] boards = new Board[20];
	
	private int boardsSize = 0;
	
	private int boardSeq = 1;
	
	
	public static void start() {
		
		BoardApp app = new BoardApp();
		
		Scanner scn = app.sc;
		
		boolean run = true;
		
		while (run) {
			
			System.out.println("-----------------------------------------------");
			System.out.println("1.등록 | 2.목록 | 3.상세보기 | 4.수정 | 5.삭제 | 9.종료");
			System.out.println("-----------------------------------------------");
			System.out.println("[번호를 입력하세요]");
			
			int menu = Integer.parseInt(scn.nextLine());
			
			switch (menu) {
				case 1:
					app.addBoard();
					break;
				case 2:
					app.showBoards();
					break;
				case 3:
					app.findBoard();
					break;
				case 4:
					app.editBoard();
					break;
				case 5:
					app.deleteBoard();
					break;
				case 9:
					run = false;
					break;
				default:
					System.out.println("번호를 잘못 입력하셨습니다.");
					break;
			}
			
			System.out.print("\n\n\n");
			
		}
		
	}


	private void addBoard() {
		
		System.out.println("-------------");
		System.out.println("게시글 등록입니다.");
		System.out.println("-------------");
		
		System.out.println("제목 >>");
		String title =  sc.nextLine();
		System.out.println("내용 >>");
		String content =  sc.nextLine();
		System.out.println("작성자 >>");
		String writer =  sc.nextLine();
	
		
		boards[boardsSize++] = new Board(
				boardSeq++, title, content, writer);
		
		System.out.println("게시글이 등록되었습니다.");
		
	}


	private void showBoards() {
	
		System.out.println("-------------");
		System.out.println("게시글 목록입니다.");
		System.out.println("-------------");
		
		System.out.println("-----------------------------------------------");
		System.out.printf("%4s   %-25s  %-4s\n", "글번호", "제목", "작성자");
		System.out.println("-----------------------------------------------");
		for (int i = 0; i < boardsSize; i++) {
			boards[i].showBoardSimple();
		}
		System.out.println("-----------------------------------------------");
			
	}


	private void findBoard() {
		
		System.out.println("-------------");
		System.out.println("게시글 조회입니다.");
		System.out.println("-------------");
		
		System.out.println("[조회할 게시글의 번호를 입력하세요]");
		
		int targetNum = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < boardsSize; i++) {
			if (boards[i].getNum() == targetNum) {
				boards[i].showBoardDetail();
			}
		}
		
	}


	private void editBoard() {

		System.out.println("-------------");
		System.out.println("게시글 수정입니다.");
		System.out.println("-------------");
		
		System.out.println("[수정할 게시글의 번호를 입력하세요]");
		
		int targetNum = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < boardsSize; i++) {
			if (boards[i].getNum() == targetNum) {
				System.out.println("제목 >>");
				boards[i].setTitle(sc.nextLine());
				System.out.println("글내용 >>");
				boards[i].setContent(sc.nextLine());
			}
		}
		
		System.out.println("게시글이 수정되었습니다.");
		
	}


	private void deleteBoard() {
		
		System.out.println("-------------");
		System.out.println("게시글 삭제입니다.");
		System.out.println("-------------");
		
		System.out.println("[삭제할 게시글의 번호를 입력하세요]");
		
		int targetNum = Integer.parseInt(sc.nextLine());
		
		for (int i = 0; i < boardsSize; i++) {
			if (boards[i].getNum() == targetNum) {
				for (int j = i; j < boardsSize; j++) {
					boards[j] = boards[j + 1];
				}
				boards[--boardsSize] = null;
			}
		}
		
		System.out.println("게시글이 삭제되었습니다.");
		
	}
	
}
