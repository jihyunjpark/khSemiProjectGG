package board.show.model.vo;

public class ShowVo {
//	SHOW_IMAGE	VARCHAR2(4000 BYTE)
//	SHOW_CODE	NUMBER
//	SHOW_GRADE	NUMBER(2,0)
//	SHOW_NAME	VARCHAR2(512 BYTE)
//	GENRE	VARCHAR2(512 BYTE)
//	GUEST	VARCHAR2(512 BYTE)
//	THEATER_NO	NUMBER(12,0)
//	REVIEW_COUNT	NUMBER
//	SEEN_COUNT	NUMBER
//	WISH_COUNT	NUMBER
	private String show_image;
	private int show_code;
	private int show_grade;
	private String show_name;
	private String genre;
	private String guest;
	private int theater_no;
	private int review_count;
	private int seen_count;
	private int wish_count;
	private String location;
	private String category;
	private String period;
	private String show_runtime;
	private String sub_image;
	
	public ShowVo(){}

	public ShowVo(String show_image, int show_code, int show_grade, String show_name, String genre, String guest,
			int theater_no, int review_count, int seen_count, int wish_count) {
		this.show_image = show_image;
		this.show_code = show_code;
		this.show_grade = show_grade;
		this.show_name = show_name;
		this.genre = genre;
		this.guest = guest;
		this.theater_no = theater_no;
		this.review_count = review_count;
		this.seen_count = seen_count;
		this.wish_count = wish_count;
	}

	public String getShow_image() {
		return show_image;
	}

	public void setShow_image(String show_image) {
		this.show_image = show_image;
	}

	public int getShow_code() {
		return show_code;
	}

	public void setShow_code(int show_code) {
		this.show_code = show_code;
	}

	public int getShow_grade() {
		return show_grade;
	}

	public void setShow_grade(int show_grade) {
		this.show_grade = show_grade;
	}

	public String getShow_name() {
		return show_name;
	}

	public void setShow_name(String show_name) {
		this.show_name = show_name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getGuest() {
		return guest;
	}

	public void setGuest(String guest) {
		this.guest = guest;
	}

	public int getTheater_no() {
		return theater_no;
	}

	public void setTheater_no(int theater_no) {
		this.theater_no = theater_no;
	}

	public int getReview_count() {
		return review_count;
	}

	public void setReview_count(int review_count) {
		this.review_count = review_count;
	}

	public int getSeen_count() {
		return seen_count;
	}

	public void setSeen_count(int seen_count) {
		this.seen_count = seen_count;
	}

	public int getWish_count() {
		return wish_count;
	}

	public void setWish_count(int wish_count) {
		this.wish_count = wish_count;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getShow_runtime() {
		return show_runtime;
	}

	public void setShow_runtime(String show_runtime) {
		this.show_runtime = show_runtime;
	}

	public String getSub_image() {
		return sub_image;
	}

	public void setSub_image(String sub_image) {
		this.sub_image = sub_image;
	}
}

