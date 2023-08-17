package co.yedam.board;

public class Board {
	
	private int num;
	
	private String title;
	
	private String content;
	
	private String writer;
	

	public Board(int num, String title, String content, String writer) {
		this.num = num;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	
	public void showBoardSimple() {
		System.out.printf("%4d    %-25s %-4s\n", this.num, this.title, this.writer);
	}
	
	public void showBoardDetail() {
		System.out.printf("글번호 : %d  작성자 : %s\n", this.num, this.writer);
		System.out.printf("글제목 : %s\n", this.title);
		System.out.printf("글내용 : %s\n", this.content);
	}
}
