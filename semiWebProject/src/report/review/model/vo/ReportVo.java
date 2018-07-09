package report.review.model.vo;

import java.util.Date;

public class ReportVo {
	private int no;
	private String writer;
	private int point;
	private String content;
	private Date writeDate;
	private int rcount;
	private char wish;
	private int showCode;
	private String writerName;
	
	public ReportVo(){}
	
	public ReportVo(int no,String nick,String content,Date writeDate,int rcount){
		this.no=no;
		this.writerName=nick;
		this.content=content;
		this.writeDate=writeDate;
		this.rcount=rcount;
	}
	
	
	public ReportVo(int no,String writer,String writerName ,int point,String content,Date writeDate, int rcount, char wish, int showCode){
		this.no=no;
		this.writer=writer;
		this.writerName=writerName;
		this.point=point;
		this.content=content;
		this.writeDate=writeDate;
		this.showCode=showCode;
		this.rcount=rcount;
		this.wish=wish;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public String getNick() {
		return writerName;
	}

	public void setNick(String nick) {
		this.writerName = nick;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public int getShowCode() {
		return showCode;
	}

	public void setShowCode(int showCode) {
		this.showCode = showCode;
	}

	public int getRcount() {
		return rcount;
	}

	public void setRcount(int rcount) {
		this.rcount = rcount;
	}

	public char getWish() {
		return wish;
	}

	public void setWish(char wish) {
		this.wish = wish;
	}

	@Override
	public String toString() {
		return "ReportVo [no=" + no + ", writer=" + writer + ", writerName=" + writerName +", point=" + point + ", content=" + content
				+ ", writeDate=" + writeDate + ", rcount=" + rcount + ", wish=" + wish + ", showCode=" + showCode+  "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

