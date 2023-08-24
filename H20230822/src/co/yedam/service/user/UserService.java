package co.yedam.service.user;

import co.yedam.vo.User;

// 파일, DB 로부터 회원정보를 불러옴
public interface UserService {

	// main method
	public String checkLogin(User user); // 아이디/비밀번호 검증
	
}
