package co.yedam.board;

import java.util.List;

// 파일 저장, DB 저장
public interface BoardService {
	
	// 등록(추가)
	public boolean add(Board board);
	
	// 목록
	public List<Board> list(int page);
	
	// 상세조회
	public Board search(int brdNo);
	
	// 수정 : 내용만 수정
	public boolean modify(Board board);
	
	// 삭제
	public boolean remove(int brdNo);
	
	// 종료
	public void exit();
	
	// 전체 개수
	public int getTotal();
	
}
