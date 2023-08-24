package co.yedam.service.board;

import java.util.List;

import co.yedam.vo.Board;

public interface BoardService {
	
	// main method
	public boolean add(Board board); // 등록(추가)
	
	public List<Board> list(int page); // 목록
	
	public Board search(int brdNo); // 상세조회
	
	public boolean modify(Board board); // 수정 : 내용만 수정
	
	public boolean remove(int brdNo); // 삭제
	
	public void exit(); // 종료
	
	
	// sub method
	public int getTotal(); // 전체 개수 반환
	
	public String getResponseUser(int brdNo); // 글 번호 -> 작성자 반환
	
}
