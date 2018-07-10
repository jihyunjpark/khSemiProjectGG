package board.faq.model.vo;

import java.util.Date;

public class FaqVo {
	
	private int faq_no;
	private String faq_title;
	private String faq_content;
	private Date faq_date;
	
	public FaqVo(){}

	public FaqVo(int faq_no, String faq_title, String faq_content, Date faq_date) {
		super();
		this.faq_no = faq_no;
		this.faq_title = faq_title;
		this.faq_content = faq_content;
		this.faq_date = faq_date;
	}

	public int getFaq_no() {
		return faq_no;
	}

	public void setFaq_no(int faq_no) {
		this.faq_no = faq_no;
	}

	public String getFaq_title() {
		return faq_title;
	}

	public void setFaq_title(String faq_title) {
		this.faq_title = faq_title;
	}

	public String getFaq_content() {
		return faq_content;
	}

	public void setFaq_content(String faq_content) {
		this.faq_content = faq_content;
	}

	public Date getFaq_date() {
		return faq_date;
	}

	public void setFaq_date(Date faq_date) {
		this.faq_date = faq_date;
	}

	@Override
	public String toString() {
		return "FaqVo [faq_no=" + faq_no + ", faq_title=" + faq_title + ", faq_content=" + faq_content + ", faq_date="
				+ faq_date + "]";
	}
	

}
