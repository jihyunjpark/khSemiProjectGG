package member.model.vo;

import java.sql.Date;
import java.util.List;

public class MemberVo {
	private String userId;
	private String password;
	private String nickname;
	private char gender;
	private String email;
	private String genreStr;
	private List<String> genre;
	private Date enrolldate;
	
	public MemberVo(){
	}
	
	public MemberVo(String userId, String nickname) {
		this.userId = userId;
		this.nickname = nickname;
	}


	public MemberVo(String userId, String password, String nickname, char gender, String email, String genreStr) {
		this.userId = userId;
		this.password = password;
		this.nickname = nickname;
		this.gender = gender;
		this.email = email;
		this.genreStr = genreStr;
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
	public List<String> getGenre() {
		return genre;
	}
	public void setGenre(List<String> genre) {
		this.genre = genre;
	}
	public Date getEnrolldate() {
		return enrolldate;
	}
	public void setEnrolldate(Date enrolldate) {
		this.enrolldate = enrolldate;
	}
	public String getGenreStr() {
		return genreStr;
	}
	public void setGenreStr(String genreStr) {
		this.genreStr = hobbyStr;
	}
	@Override
	public String toString() {
		return "MemberVo [userId=" + userId + ", password=" + password + ", userName=" + userName + ", gender=" + gender
				+ ", age=" + age + ", email=" + email + ", phone=" + phone + ", address=" + address + ", genreStr="
				+ genreStr + ", genre=" + genre + ", enrolldate=" + enrolldate + "]";
	}
}
