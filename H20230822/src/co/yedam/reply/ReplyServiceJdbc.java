package co.yedam.reply;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.Dao;

public class ReplyServiceJdbc implements ReplyService {

	// field
	private Connection conn; // DB 연결용
	
	private PreparedStatement psmt; // SQL 삽입용
	
	private ResultSet rs; // 결과 임시저장 공간
	
	private String query; // 쿼리 임시저장 공간
	
	
	// override method
	@Override
	public boolean add(Reply reply) {
		conn = Dao.conn();
		query = "INSERT INTO replies "
				+ "VALUES ((SELECT NVL(MAX(rep_no), 0) + 1 FROM replies), ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, reply.getBrdNo());
			psmt.setString(2, reply.getRepContent());
			psmt.setString(3, reply.getRepWriter());
			int numIns = psmt.executeUpdate();
			if (numIns == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}

	@Override
	public List<Reply> list(int brdNo, int page) {
		List<Reply> list = new ArrayList<>();
		conn = Dao.conn();
		query = "SELECT * "
				+ "FROM (SELECT ROWNUM rn, a.* "
				+ "      FROM (SELECT * "
				+ "            FROM replies "
				+ "            WHERE brd_no = ? "
				+ "            ORDER BY rep_no) a "
				+ "      WHERE ROWNUM <= (? * 5)) b "
				+ "WHERE b.rn > ((? - 1) * 5)";
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, brdNo);
			psmt.setInt(2, page);
			psmt.setInt(3, page);
			rs = psmt.executeQuery();
			while (rs.next()) {
				list.add(new Reply(
						rs.getInt("rep_no"),
						rs.getInt("brd_no"),
						rs.getString("rep_content"),
						rs.getString("rep_writer")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	@Override
	public boolean remove(int repNo) {
		conn = Dao.conn();
		query = "DELETE FROM replies WHERE rep_no = ?";
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, repNo);
			int numDel = psmt.executeUpdate();
			if (numDel == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
	}
	
	@Override
	public int getTotal(int brdNo) {
		conn = Dao.conn();
		query = "SELECT COUNT(*) "
				+ "FROM replies "
				+ "WHERE brd_no = ?";
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, brdNo);
			rs = psmt.executeQuery();
			while (rs.next()) {
				return rs.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return 0;
	}
	
	@Override
	public String getResponseUser(int repNo) {
		conn = Dao.conn();
		query = "SELECT rep_writer "
				+ "FROM replies "
				+ "WHERE rep_no = ?";
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, repNo);
			rs = psmt.executeQuery();
			while (rs.next()) {
				return rs.getString("rep_writer");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
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
