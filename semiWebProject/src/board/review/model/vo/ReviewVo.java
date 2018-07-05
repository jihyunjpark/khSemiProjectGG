package board.review.model.vo;

import java.util.Date;

public class ReviewVo {
	private int reviewNo;
	private String memberId;
	private String memberName;
	private int pointgrade;
	private String content;
	private Date reviewDate;
	private int showcode;
	private int reportCount;
	
	public ReviewVo() {
		// TODO Auto-generated constructor stub
	}

	public ReviewVo(String memberId, String memberName, int pointgrade, String content, int showcode) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.pointgrade = pointgrade;
		this.content = content;
		this.showcode = showcode;
	}

	public ReviewVo(int reviewNo, String memberId, String memberName, int pointgrade, String content, Date reviewDate, int showcode,
			int reportCount) {
		this.reviewNo = reviewNo;
		this.memberId = memberId;
		this.memberName = memberName;
		this.pointgrade = pointgrade;
		this.content = content;
		this.reviewDate = reviewDate;
		this.showcode = showcode;
		this.reportCount = reportCount;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getPointgrade() {
		return pointgrade;
	}

	public void setPointgrade(int pointgrade) {
		this.pointgrade = pointgrade;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public int getShowcode() {
		return showcode;
	}

	public void setShowcode(int showcode) {
		this.showcode = showcode;
	}

	public int getReportCount() {
		return reportCount;
	}

	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
	}

}
