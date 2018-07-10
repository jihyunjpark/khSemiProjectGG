package magazine.model.vo;

import java.util.Date;

public class AttachmentVo {
	private int fno;
	private int bno;
	private int btype;
	private String origin_name;
	private String change_name;
	private String file_path;
	private char delflag;

	private String title;
	private String content;
	private Date writeDate;

	public AttachmentVo() {
	}

	public AttachmentVo(int fno, int bno, int btype, String origin_name, String change_name, String file_path,
			char delflag, String title, String content, Date writeDate) {
		super();
		this.fno = fno;
		this.bno = bno;
		this.btype = btype;
		this.origin_name = origin_name;
		this.change_name = change_name;
		this.file_path = file_path;
		this.delflag = delflag;
		
		this.title = title;
		this.content = content;
		this.writeDate = writeDate;
	}

	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public int getBtype() {
		return btype;
	}

	public void setBtype(int btype) {
		this.btype = btype;
	}

	public String getOrigin_name() {
		return origin_name;
	}

	public void setOrigin_name(String origin_name) {
		this.origin_name = origin_name;
	}

	public String getChange_name() {
		return change_name;
	}

	public void setChange_name(String change_name) {
		this.change_name = change_name;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public char getDelflag() {
		return delflag;
	}

	public void setDelflag(char delflag) {
		this.delflag = delflag;
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

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "AttachmentVo [fno=" + fno + ", bno=" + bno + ", btype=" + btype + ", origin_name=" + origin_name
				+ ", change_name=" + change_name + ", file_path=" + file_path + ", delflag=" + delflag + ", title="
				+ title + ", content=" + content + ", writeDate=" + writeDate + "]";
	}

}
