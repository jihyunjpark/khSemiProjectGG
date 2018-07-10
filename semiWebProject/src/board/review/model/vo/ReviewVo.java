package board.review.model.vo;

import java.util.Date;

public class ReviewVo {
	private int reviewNo;
	private String memberId;
	private String memberName;
	private int pointgrade;
	private String content;
	private Date reviewDate;
	private String showcode;
	private int reportCount;
	private String wishbool;
	
	public ReviewVo() {
		// TODO Auto-generated constructor stub
	}

	public ReviewVo(String memberId, String memberName, int pointgrade, String content, String showcode) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.pointgrade = pointgrade;
		this.content = content;
		this.showcode = showcode;
	}

	public ReviewVo(int reviewNo, String memberId, String memberName, int pointgrade, String content, Date reviewDate, String showcode,
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
	
	

	public String isWishbool() {
		return wishbool;
	}

	public void setWishbool(String wishbool) {
		this.wishbool = wishbool;
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

	public String getShowcode() {
		return showcode;
	}

	public void setShowcode(String showcode) {
		this.showcode = showcode;
	}

	public int getReportCount() {
		return reportCount;
	}

	public void setReportCount(int reportCount) {
		this.reportCount = reportCount;
	}

}
