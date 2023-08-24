package co.yedam.vo;

public class User {
	
	// field
	private String userName; // user_name
	
	private String userId; // user_id
	
	private String userPwd; // user_pwd
	
	
	// constructor
	public User() {
		
	}

	public User(String userName, String userId, String userPwd) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.userPwd = userPwd;
	}
	
	public User(String userId, String userPwd) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
	}
	

	// getter, setter
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
}
