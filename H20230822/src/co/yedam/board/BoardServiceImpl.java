package co.yedam.board;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BoardServiceImpl implements BoardService {

	// field
	private List<Board> boardList = new ArrayList<>();
	
	
	// constructor
	public BoardServiceImpl() {
		init();
	}
	
	private void init() {
		try {
			ObjectInputStream ois = new ObjectInputStream(
					new FileInputStream("src/co/yedam/board/board.dat"));
			boardList = (List<Board>) ois.readObject();
			ois.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// override method
	@Override
	public boolean add(Board board) {
		board.setBrdNo(getMaxNo());
		board.setWriteDate(new Date());
		board.setUpdateDate(new Date());
		return boardList.add(board);
	}
	
	private int getMaxNo() {
		int max = -1;
		for (Board brd : boardList) {
			if (max < brd.getBrdNo()) {
				max = brd.getBrdNo();
			}
		}
		return max + 1;
	}

	@Override
	public List<Board> list(int page) {
		List<Board> pageList = new ArrayList<>();
		int start = ((page - 1) * 5);
		int end = boardList.size() < (page * 5) ? boardList.size() : (page * 5);
		for (int i = start; i < end; i++) {
			pageList.add(boardList.get(i));
		}
		return pageList;
	}

	@Override
	public Board search(int brdNo) {
		for (Board brd : boardList) {
			if (brd.getBrdNo() == brdNo) {
				return brd;
			}
		}
		return null;
	}

	@Override
	public boolean modify(Board board) {
		for (Board brd : boardList) {
			if (brd.getBrdNo() == board.getBrdNo()) {
				brd.setBrdContent(board.getBrdContent());
				brd.setUpdateDate(new Date());
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean remove(int brdNo) {
		for (Board brd : boardList) {
			if (brd.getBrdNo() == brdNo) {
				boardList.remove(brd);
				return true;
			}
		}
		return false;
	}

	@Override
	public void exit() {
		savetoFile();
	}

	private void savetoFile() {
		try {
			System.out.println("저장중입니다..");
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream("src/co/yedam/board/board.dat"));
			oos.writeObject(boardList);
			oos.flush();
			oos.close();
			System.out.println("저장 완료!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getTotal() {
		return boardList.size();
	}

	@Override
	public String getResponseUser(int brdNo) {
		for (Board brd : boardList) {
			if (brd.getBrdNo() == brdNo) {
				return brd.getBrdWriter();
			}
		}
		return null;
	}
	
}
