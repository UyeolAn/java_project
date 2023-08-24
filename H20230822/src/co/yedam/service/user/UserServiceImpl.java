package co.yedam.service.user;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.vo.User;

public class UserServiceImpl implements UserService {
	
	// field
	private List<User> userList = new ArrayList<>();
	
	
	// constructor
	public UserServiceImpl() {
		init();
	}
	
	private void init() {	
		try {
			BufferedReader br = new BufferedReader(
					new FileReader(new File("src/co/yedam/data/user.txt")));
			String line;
			while ((line = br.readLine()) != null && line != "") {
				String[] fileData = line.split(" ");
				userList.add(new User(fileData[0], fileData[1], fileData[2]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	// override method
	@Override
	public String checkLogin(User user) {
		for (User u : userList) {
			if (u.getUserId().equals(user.getUserId())) {
				if (u.getUserPwd().equals(user.getUserPwd())) {
					System.out.printf("'%s'님 로그인 하셨습니다.\n", u.getUserName());
					return u.getUserName();
				} else {
					System.out.println("비밀번호가 맞지 않습니다.");
					return null;
				}
			}
		}
		System.out.println("등록되지 않은 ID 입니다.");
		return null;
	}

}
