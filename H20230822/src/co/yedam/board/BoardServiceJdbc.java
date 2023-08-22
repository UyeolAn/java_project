package co.yedam.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardServiceJdbc implements BoardService {

	// field
	private Connection conn; // DB 연결용
	
	private PreparedStatement psmt; // SQL 삽입용
	
	private ResultSet rs; // 결과 임시저장 공간
	
	private String query; // 쿼리 임시저장 공간
	
	
	// override method
	@Override
	public boolean add(Board board) {
		return false;
	}

	@Override
	public List<Board> list(int page) {
		List<Board> list = new ArrayList<>();
		conn = Dao.conn();
		query = "SELECT * FROM board";
		try {
			psmt = conn.prepareStatement(query);
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
		}
		return list;
	}

	@Override
	public Board search(int brdNo) {
		conn = Dao.conn();
		query = "SELECT * FROM board WHERE brd_no = " + brdNo;
		try {
			psmt = conn.prepareStatement(query);
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
		}
		return null;
	}

	@Override
	public boolean modify(Board board) {
		conn = Dao.conn();
		query = "UPDATE board SET brd_content = '" + board.getBrdContent() + "' " +
				"WHERE brd_no = " + board.getBrdNo();
		try {
			psmt = conn.prepareStatement(query);
			int numUpd = psmt.executeUpdate();
			if (numUpd == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean remove(int brdNo) {
		conn = Dao.conn();
		query = "DELETE FROM board WHERE brd_no = " + brdNo;
		try {
			psmt = conn.prepareStatement(query);
			int numDel = psmt.executeUpdate(); // INSERT, UPDATE, DELETE
			if (numDel == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void exit() {
	
	}

	@Override
	public int getTotal() {
		return 0;
	}

}
