package board.show.model.vo;

public class BoxofficeShowVo {
	private String area; // 지역 울산
	private int prfdtcnt; // 상연횟수 4
	private String prfpd; // 공연기간 2016.06.07~2016.07.24
	private String cate; // 장르 연극
	private String prfplcnm; // 공연장 소공연장
	private String prfnm; // 공연명 셜록홈즈 [울산]
	private int rnum; // 순위 1
	int seatcnt; // 좌석수 212
	private String poster; // 포스터이미지 http://www.kopis.or.kr/upload/pfmPoster/PF_PF131793_160603_140415.jpg
	private String mt20id; // 공연ID PF131793
	
	public BoxofficeShowVo() {
		// TODO Auto-generated constructor stub
	}

	public BoxofficeShowVo(String area, int prfdtcnt, String prfpd, String cate, String prfplcnm, String prfnm,
			int rnum, int seatcnt, String poster, String mt20id) {
		super();
		this.area = area;
		this.prfdtcnt = prfdtcnt;
		this.prfpd = prfpd;
		this.cate = cate;
		this.prfplcnm = prfplcnm;
		this.prfnm = prfnm;
		this.rnum = rnum;
		this.seatcnt = seatcnt;
		this.poster = poster;
		this.mt20id = mt20id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getPrfdtcnt() {
		return prfdtcnt;
	}

	public void setPrfdtcnt(int prfdtcnt) {
		this.prfdtcnt = prfdtcnt;
	}

	public String getPrfpd() {
		return prfpd;
	}

	public void setPrfpd(String prfpd) {
		this.prfpd = prfpd;
	}

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public String getPrfplcnm() {
		return prfplcnm;
	}

	public void setPrfplcnm(String prfplcnm) {
		this.prfplcnm = prfplcnm;
	}

	public String getPrfnm() {
		return prfnm;
	}

	public void setPrfnm(String prfnm) {
		this.prfnm = prfnm;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public int getSeatcnt() {
		return seatcnt;
	}

	public void setSeatcnt(int seatcnt) {
		this.seatcnt = seatcnt;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getMt20id() {
		return mt20id;
	}

	public void setMt20id(String mt20id) {
		this.mt20id = mt20id;
	}
	
}
