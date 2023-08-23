package co.yedam.reply;

public class Reply {

	// field
	private int repNo; // rep_no
	
	private int brdNo; // brd_no
	
	private String repContent; // rep_content
	
	private String repWriter; // rep_writer

	
	// constructor
	public Reply() {
		
	}
	
	public Reply(int repNo, int brdNo, String repContent, String repWriter) {
		super();
		this.repNo = repNo;
		this.brdNo = brdNo;
		this.repContent = repContent;
		this.repWriter = repWriter;
	}

	public Reply(int brdNo, String repContent, String repWriter) {
		super();
		this.brdNo = brdNo;
		this.repContent = repContent;
		this.repWriter = repWriter;
	}

	
	// getter, setter
	public int getRepNo() {
		return repNo;
	}

	public void setRepNo(int repNo) {
		this.repNo = repNo;
	}

	public int getBrdNo() {
		return brdNo;
	}

	public void setBrdNo(int brdNo) {
		this.brdNo = brdNo;
	}

	public String getRepContent() {
		return repContent;
	}

	public void setRepContent(String repContent) {
		this.repContent = repContent;
	}

	public String getRepWriter() {
		return repWriter;
	}

	public void setRepWriter(String repWriter) {
		this.repWriter = repWriter;
	}

	
	// override method
	@Override
	public String toString() {
		return "Reply [repNo=" + repNo + ", brdNo=" + brdNo + ", repContent=" + repContent + ", repWriter=" + repWriter
				+ "]";
	}
	
	
	// method
	public String listInfo() {
		return String.format("  => %d.  %s <%s>", repNo, repContent, repWriter);
	}
	
}
