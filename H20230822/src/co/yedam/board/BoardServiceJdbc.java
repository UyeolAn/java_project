package co.yedam.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.Dao;

public class BoardServiceJdbc implements BoardService {

	// field
	private Connection conn; // DB 연결용
	
	private PreparedStatement psmt; // SQL 삽입용
	
	private ResultSet rs; // 결과 임시저장 공간
	
	private String query; // 쿼리 임시저장 공간
	
	
	// override method
	@Override
	public boolean add(Board board) {
		conn = Dao.conn();
		query = "INSERT INTO board (brd_no, brd_title, brd_content, brd_writer) "
				 + "VALUES ((SELECT NVL(MAX(brd_no), 0) + 1 FROM board), ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, board.getBrdTitle());
			psmt.setString(2, board.getBrdContent());
			psmt.setString(3, board.getBrdWriter()); 
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
	public List<Board> list(int page) {
		List<Board> list = new ArrayList<>();
		conn = Dao.conn();
		query = "SELECT * "
				+ "FROM (SELECT ROWNUM rn, a.* "
				+ "      FROM (SELECT * "
				+ "            FROM board "
				+ "            ORDER BY brd_no) a "
				+ "      WHERE ROWNUM <= (? * 5)) b "
				+ "WHERE b.rn > ((? - 1) * 5)";
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, page);
			psmt.setInt(2, page);
			rs = psmt.executeQuery(); // SELECT
			while (rs.next()) {
				Board board = new Board();
				board.setBrdNo(rs.getInt("brd_no"));
				board.setBrdTitle(rs.getString("brd_title"));
				board.setBrdContent(rs.getString("brd_content"));
				board.setBrdWriter(rs.getString("brd_writer"));
				list.add(board);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	@Override
	public Board search(int brdNo) {
		conn = Dao.conn();
		query = "SELECT * FROM board WHERE brd_no = ?";
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, brdNo);
			rs = psmt.executeQuery();
			if (rs.next()) {
				return new Board(
						rs.getInt("brd_no"),
						rs.getString("brd_title"),
						rs.getString("brd_content"),
						rs.getString("brd_writer"),
						rs.getDate("write_date"),
						rs.getDate("update_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return null;
	}

	@Override
	public boolean modify(Board board) {
		conn = Dao.conn();
		query = "UPDATE board "
				+ "SET brd_content = ?, update_date = ? "
				+ "WHERE brd_no = ?";
		try {
			psmt = conn.prepareStatement(query);
			psmt.setString(1, board.getBrdContent());
			psmt.setDate(2, new java.sql.Date(System.currentTimeMillis()));
			psmt.setInt(3, board.getBrdNo());
			int numUpd = psmt.executeUpdate();
			if (numUpd == 1) {
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
	public boolean remove(int brdNo) {
		conn = Dao.conn();
		query = "DELETE FROM board WHERE brd_no = ?";
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, brdNo);
			int numDel = psmt.executeUpdate(); // INSERT, UPDATE, DELETE
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
	public void exit() {
	
	}

	@Override
	public int getTotal() {
		conn = Dao.conn();
		query = "SELECT COUNT(*) "
				+ "FROM board";
		try {
			psmt = conn.prepareStatement(query);
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
	public String getResponseUser(int brdNo) {
		conn = Dao.conn();
		query = "SELECT brd_writer "
				+ "FROM board "
				+ "WHERE brd_no = ?";
		try {
			psmt = conn.prepareStatement(query);
			psmt.setInt(1, brdNo);
			rs = psmt.executeQuery();
			while (rs.next()) {
				return rs.getString("brd_writer");
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
