package co.yedam;

import java.util.List;
import java.util.Scanner;

import co.yedam.board.Board;
import co.yedam.board.BoardService;
import co.yedam.board.BoardServiceJdbc;
import co.yedam.user.User;
import co.yedam.user.UserService;
import co.yedam.user.UserServiceJdbc;

public class BoardApp {
	
	// field
	private Scanner scn = new Scanner(System.in);
	
	private BoardService boardService = new BoardServiceJdbc();
	
	private UserService userService = new UserServiceJdbc();
	
	private String loginUserName = null;
	
	
	// method
	public void start() {
		
		boolean run = true;
		
		while (true) {
			
			System.out.println("-----------");
			System.out.println("로그인 입니다.");
			System.out.println("-----------");
			
			System.out.println("ID >>");
			String id =  scn.nextLine();
			
			System.out.println("pwd >>");
			String pwd =  scn.nextLine();
			
			User loginUser = new User(id, pwd);
			
			loginUserName = userService.checkLogin(loginUser);
			if (loginUserName != null) {
				System.out.print("\n\n\n");
				break;
			}
			
			System.out.print("\n\n\n");
			
		}
	
		while (run) {
		
			System.out.println("-------------------------------------------------");
			System.out.println("1.등록 | 2.목록 | 3.상세조회 | 4.수정 | 5.삭제 | 9.종료");
			System.out.println("-------------------------------------------------");
			System.out.println("번호 >>");
			
			int menu = inputNumber();
			
			switch (menu) {
				case 1:
					addBoard();
					break;
				case 2:
					showAll();
					break;
				case 3:
					searchBoard();
					break;
				case 4:
					modifyBoard();
					break;
				case 5:
					removeBoard();
					break;
				case 9:
					boardService.exit();
					run = false;
					break;
				default:
					System.out.println("번호를 다시 입력하세요.");
					break;
			}
			
			System.out.print("\n\n\n");
			
		}
		
		System.out.println("프로그램을 종료합니다.");
		scn.close();
		
	}
	
	private int inputNumber() {
		try {
			return Integer.parseInt(scn.nextLine());
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	private void addBoard() {
		
		System.out.println("-------------");
		System.out.println("게시글 등록입니다.");
		System.out.println("-------------");
		
		System.out.println("제목 >>");
		String title =  scn.nextLine();
		
		System.out.println("내용 >>");
		String content =  scn.nextLine();
		
		Board brd = new Board(title, content, loginUserName);
		if (boardService.add(brd)) {
			System.out.println("등록 성공!");
		}
		
	}

	private void showAll() {
		
		System.out.println("-------------");
		System.out.println("게시글 목록입니다.");
		System.out.println("-------------");
		
		while (true) {
			System.out.println("페이지 번호(종료:-1) >>");
			
			int page = inputNumber();
			if (page == -1) break;
			
			int lastPage = (int) Math.ceil(boardService.getTotal() / 5.0);
			
			List<Board> list = boardService.list(page);
			
			System.out.printf("=== %d/%d page ===\n", page, lastPage);
			System.out.println("-----------------------------------------------------");
			for (Board brd : list) {
				System.out.println(brd.listInfo());
			}
			System.out.println("-----------------------------------------------------");
		}
		
		
	}

	private void searchBoard() {
		
		System.out.println("-----------------");
		System.out.println("게시글 상세 조회입니다.");
		System.out.println("-----------------");
		
		System.out.println("번호 >>");
		int targetNo = parseNumber(scn.nextLine());
		
		Board searchBoard = boardService.search(targetNo);
		if (searchBoard != null) {
			System.out.println(searchBoard.showInfo());
		} else {
			System.out.println("조회 실패.");
		}
		
	}
	
	private int parseNumber(String num) {
		try {
			return Integer.parseInt(num);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	private void modifyBoard() {
		
		System.out.println("-------------");
		System.out.println("게시글 수정입니다.");
		System.out.println("-------------");
		
		System.out.println("수정대상 번호 >>");
		int targetNo = parseNumber(scn.nextLine());
		
		String responseUser = boardService.getResponseUser(targetNo);
		if (responseUser == null) {
			System.out.println("해당 번호의 게시글은 존재하지 않습니다.");
			return;
		}
		if (!responseUser.equals(loginUserName)) {
			System.out.println("수정 권한이 없습니다.");
			return;
		}
		
		System.out.println("수정 내용 >>");
		String newContent = scn.nextLine();
		
		Board brd = new Board();
		brd.setBrdNo(targetNo);
		brd.setBrdContent(newContent);
		
		if (boardService.modify(brd)) {
			System.out.println("수정 성공!");
		} else {
			System.out.println("수정 실패");
		}
		
	}

	private void removeBoard() {
		
		System.out.println("-------------");
		System.out.println("게시글 삭제입니다.");
		System.out.println("-------------");
		
		System.out.println("번호 >>");
		int targetNo = parseNumber(scn.nextLine());
		
		String responseUser = boardService.getResponseUser(targetNo);
		if (responseUser == null) {
			System.out.println("해당 번호의 게시글은 존재하지 않습니다.");
			return;
		}
		if (!responseUser.equals(loginUserName)) {
			System.out.println("삭제 권한이 없습니다.");
			return;
		}
		
		if (boardService.remove(targetNo)) {
			System.out.println("삭제 성공!");
		} else {
			System.out.println("삭제 실패");
		}
		
	}
	
}
