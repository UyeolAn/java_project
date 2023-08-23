package co.yedam.board;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Board implements Serializable {	
	
	// field
	private int brdNo; // brd_no
	
	private String brdTitle; // brd_title
	
	private String brdContent; // brd_content
	
	private String brdWriter; // brd_writer
	
	private Date writeDate; // write_date
	
	private Date updateDate; // update_date
	
	
	// constructor
	public Board() {
		
	}
	
	public Board(String brdTitle, String brdContent, String brdWriter) {
		super();
		this.brdTitle = brdTitle;
		this.brdContent = brdContent;
		this.brdWriter = brdWriter;
	}

	public Board(int brdNo, String brdTitle, String brdContent, 
			String brdWriter, Date writeDate, Date updateDate) {
		super();
		this.brdNo = brdNo;
		this.brdTitle = brdTitle;
		this.brdContent = brdContent;
		this.brdWriter = brdWriter;
		this.writeDate = writeDate;
		this.updateDate = updateDate;
	}
	
	
	// getter, setter
	public int getBrdNo() {
		return brdNo;
	}

	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
	}

	public String getBrdTitle() {
		return brdTitle;
	}

	public void setBrdTitle(String brdTitle) {
		this.brdTitle = brdTitle;
	}

	public String getBrdContent() {
		return brdContent;
	}

	public void setBrdContent(String brdContent) {
		this.brdContent = brdContent;
	}

	public String getBrdWriter() {
		return brdWriter;
	}

	public void setBrdWriter(String brdWriter) {
		this.brdWriter = brdWriter;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	
	// override method
	@Override
	public String toString() {
		return "Board [brdNo=" + brdNo + ", brdTitle=" + brdTitle + 
				", brdContent=" + brdContent + ", brdWriter=" + brdWriter + 
				", writeDate=" + writeDate + ", updateDate=" + updateDate + "]";
	}
	
	
	// method
	public String listInfo() {
		return String.format("[%d] %s <%s> 댓글:", brdNo, brdTitle, brdWriter);
	}
	
	public String showInfo() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd HH:mm:ss");
		String result = "";
		result += "No." + brdNo + " " + brdTitle + " <" + brdWriter + ">\n";
		result += "\n" + brdContent + "\n";
		result += "\n생성 날짜 : " + sdf.format(writeDate) + "\n";
		result += "수정 날짜 : " + sdf.format(updateDate);
		return result;
	}
	
}
