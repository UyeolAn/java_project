package co.yedam.service.reply;

import java.util.List;

import co.yedam.vo.Reply;


public interface ReplyService {

	// main method
	public boolean add(Reply reply); // 등록(추가)

	public List<Reply> list(int brdNo, int page); // 목록
	
	public boolean remove(int repNo); // 삭제
	
	
	// sub method
	public int getTotal(int brdNo); // 전개 개수 반환
	
	public String getResponseUser(int repNo); // 댓글 번호 -> 작성자 반환
	
}
