package report.comment.model.vo;

import java.util.Date;

public class CommentVo {
	private int cno;
	private int bno;
	private String content;
	private String writer;
	private String writerName;
	private Date writeDate;
	private char delFlag;
	private int rcount;
	
	

	public CommentVo(){}

	public CommentVo(int cno, String content, String writer) {
		this.cno=cno;
		this.content = content;
		this.writer = writer;
	}

	public CommentVo(int cno, int bno, String writer , String content, String writerName ,char delFlag,  Date writeDate ,int rcount) {
		this.cno=cno;
		this.bno = bno;
		this.content = content;
		this.writer = writer;
		this.writerName = writerName;
		this.delFlag=delFlag;
		this.writeDate = writeDate;
		this.rcount=rcount;
	}
	
	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public char getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(char delFlag) {
		this.delFlag = delFlag;
	}

	public int getRcount() {
		return rcount;
	}
	
	public void setRcount(int rcount) {
		this.rcount = rcount;
	}


	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
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

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName= writerName;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "CommentVo [cno=" + cno + ", bno=" + bno +  ", writer=" + writer + ", content=" +
				content + ", writerName=" + writerName + ", delFlag=" + delFlag + ", writeDate=" + writeDate + ", rcount="
				+ rcount + "]";
	}


}












