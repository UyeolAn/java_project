package co.yedam.friend;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {

	private String name;
	
	private String phone;
	
	private Date birth; // yyyy-MM-dd

	
	public Friend(String name, String phone, Date birth) {
		this.name = name;
		this.phone = phone;
		this.birth = birth;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Date getBirth() {
		return birth;
	}


	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return String.format("이름 : %s, 번호 : %s, 생년월일 : %s", 
				this.name, this.phone, sdf.format(this.birth));		
	}
	
}
