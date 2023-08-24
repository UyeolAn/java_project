package co.yedam.service.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.yedam.common.Dao;
import co.yedam.vo.User;

public class UserServiceJdbc implements UserService {
	
	// field
	private Connection conn; // DB 연결용
	
	private PreparedStatement psmt; // SQL 삽입용
	
	private ResultSet rs; // 결과 임시저장 공간
	
	private String query; // 쿼리 임시저장 공간
	
	
	// override method
	@Override
	public boolean add(User user) {
		conn = Dao.conn();
		query = "INSERT INTO user"
				 + "VALUES (?, ?, ?)";
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, user.getUserName());
			psmt.setString(2, user.getUserId());
			psmt.setString(3, user.getUserPwd());
			int numIns = psmt.executeUpdate();
			if (numIns == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public String checkLogin(User user) {
		conn = Dao.conn();
		query = "SELECT * "
				+ "FROM users "
				+ "WHERE user_id = ?";
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, user.getUserId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				if (rs.getString("user_pwd").equals(user.getUserPwd())) {
					System.out.printf("'%s'님 로그인 하셨습니다.\n", rs.getString("user_name"));
					return rs.getString("user_name");
				} else {
					System.out.println("비밀번호가 맞지 않습니다.");
					return null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		System.out.println("등록되지 않은 ID 입니다.");
		return null;
	}
	
	
	// method
	private void disconn() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
