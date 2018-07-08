package board.free.model.vo;

import java.util.Date;

public class FreeReplyVo {
	private int reply_no;
	private int board_no;
	private String member_id;
	private String reply_content;
	private Date reply_date;
	private String del_flag;
	private String nickname;
	private String reply_date_str;
	
	public FreeReplyVo(){}

	public int getReply_no() {
		return reply_no;
	}

	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public Date getReply_date() {
		return reply_date;
	}

	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}

	public String getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(String del_flag) {
		this.del_flag = del_flag;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getReply_date_str() {
		return reply_date_str;
	}

	public void setReply_date_str(String reply_date_str) {
		this.reply_date_str = reply_date_str;
	}
	
	
	
	
}
