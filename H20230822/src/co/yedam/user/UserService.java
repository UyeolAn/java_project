package co.yedam.user;

// 파일, DB 로부터 회원정보를 불러옴
public interface UserService {

	public String checkLogin(User user); // 아이디/비밀번호 검증
	
}
