package member.model.vo;

import java.sql.Date;
import java.util.List;

public class MemberVo {
	private String userId;
	private String password;
	private String nickname;
	private char gender;
	private String email;
	private Date enrolldate;
	private int member_grade;
	
	public MemberVo(){
	}
	
	public MemberVo(String userId, String nickname) {
		this.userId = userId;
		this.nickname = nickname;
	}


	public MemberVo(String userId, String password, String nickname, String email, char gender) {
		this.userId = userId;
		this.password = password;
		this.nickname = nickname;
		this.email = email;
		this.gender = gender;
	}

	//userId
	public void setUserId(String userId){
		this.userId = userId;
	}
	public String getUserId(){
		return userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getEnrolldate() {
		return enrolldate;
	}
	public void setEnrolldate(Date enrolldate) {
		this.enrolldate = enrolldate;
	}
 
	public int getMember_grade() {
		return member_grade;
	}

	public void setMember_grade(int member_grade) {
		this.member_grade = member_grade;
	}

	@Override
	public String toString() {
		return "MemberVo [userId=" + userId + ", password=" + password + ", nickname=" + nickname + ", gender=" + gender
				+ ", email=" + email + ", enrolldate=" + enrolldate + "]";
	}

}
