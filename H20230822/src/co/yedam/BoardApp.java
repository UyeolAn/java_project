package co.yedam;

import java.util.List;
import java.util.Scanner;

import co.yedam.board.Board;
import co.yedam.board.BoardService;
import co.yedam.board.BoardServiceJdbc;
import co.yedam.reply.Reply;
import co.yedam.reply.ReplyService;
import co.yedam.reply.ReplyServiceJdbc;
import co.yedam.user.User;
import co.yedam.user.UserService;
import co.yedam.user.UserServiceJdbc;

public class BoardApp {
	
	// constant field
	private final Scanner scn = new Scanner(System.in);
	
	private final BoardService boardService = new BoardServiceJdbc();
	
	private final UserService userService = new UserServiceJdbc();
	
	// field
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
			
			System.out.println("---------------------------------------------");
			System.out.println(searchBoard.showInfo());
			System.out.println("---------------------------------------------");
			
			ReplyApp app = new ReplyApp(targetNo);
			
			app.start();
			
			
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
			// TODO : 게시글을 삭제하면 해당 게시글의 댓글도 전부 삭제
		} else {
			System.out.println("삭제 실패");
		}
		
	}
	
	
	// inner class
	class ReplyApp {
		
		// constant field
		private final ReplyService replyService = new ReplyServiceJdbc();
		
		// field
		private int brdNo;

		
		// constructor
		public ReplyApp() {
			
		}
		
		public ReplyApp(int brdNo) {
			super();
			this.brdNo = brdNo;
		}


		// getter, setter
		public int getBrdNo() {
			return brdNo;
		}

		public void setBrdNo(int brdNo) {
			this.brdNo = brdNo;
		}
		
		
		// method
		public void start() {
			
			int repPage = 1;
			boolean repRun = true;
			
			while (repRun) {
				
				System.out.println("---------------------------------------------");
				
				int lastPage = (int) Math.ceil(replyService.getTotal(brdNo) / 5.0);
				
				List<Reply> list = replyService.list(brdNo, repPage);
				if (list.isEmpty()) {
					System.out.println("댓글이 없습니다...");
				} else {
					System.out.printf("  [댓글 목록 %d/%d]\n", repPage, lastPage);
					for (Reply rep : list) {
						System.out.println(rep.listInfo());
					}
				}
				
				System.out.println("---------------------------------------------");
				System.out.println("1.이전 | 2.다음 | 3.댓글등록 | 4.댓글삭제 | 9.매뉴로");
				System.out.println("---------------------------------------------");
				System.out.println("번호 >>");
				
				int repMenu = inputNumber();
				
				switch (repMenu) {
				
					case 1:
						if (repPage > 1) {
							repPage--;
						} else {
							System.out.println("첫 번째 페이지입니다.");
						}
						break;
					case 2:
						if (repPage < lastPage) {
							repPage++;
						} else {
							System.out.println("마지막 페이지입니다.");
						}
						break;
					case 3:
						addReply(brdNo);
						break;
					case 4:
						deleteReply();
						break;
					case 9:
						System.out.println("메뉴로 돌아갑니다...");
						repRun = false;
						break;	
						
				}
				
				System.out.print("\n\n\n");
				
			}
			
		}
		
		private void addReply(int brdNo) {
			
			System.out.println("댓글을 입력하세요 >>");
			String content =  scn.nextLine();
			
			Reply reply = new Reply(brdNo, content, loginUserName);
			if (replyService.add(reply)) {;
				System.out.println("댓글등록 성공!");
			}
			
		}
		
		private void deleteReply() {
			
			System.out.println("댓글 번호 >>");
			int targetRepNo =  parseNumber(scn.nextLine());
			
			String responseUser = replyService.getResponseUser(targetRepNo);
			if (responseUser == null) {
				System.out.println("해당 번호의 댓글은 존재하지 않습니다.");
				return;
			}
			if (!responseUser.equals(loginUserName)) {
				System.out.println("삭제 권한이 없습니다.");
				return;
			}
			
			if (replyService.remove(targetRepNo)) {
				System.out.println("삭제 성공!");
			} else {
				System.out.println("삭제 실패");
			}
			
		}
		
	}
	
}
