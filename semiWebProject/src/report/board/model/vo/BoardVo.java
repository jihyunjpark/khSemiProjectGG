package report.board.model.vo;

import java.util.Date;

public class BoardVo {
	private int no;
	private String title;
	private String content;
	private String writer;
	private String writerName;
	private int count;
	private Date writeDate;
	private int rcount;
	
	public BoardVo(){}

	public BoardVo(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public BoardVo(int no, String title, String conten,String writer , String writerName , int count, Date writeDate ,int rcount) {
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.count = count;
		this.writeDate = writeDate;
		this.rcount=rcount;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public int getRcount() {
		return rcount;
	}

	public void setRcount(int rcount) {
		this.rcount = rcount;
	}
	
	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", content=" + content + ", writer=" + writer +", writername=" + writerName + ", count="
				+ count + ", writeDate=" + writeDate + ", rcount=" + rcount + "]";
	}
}












