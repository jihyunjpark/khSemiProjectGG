package board.show.model.vo;

public class ShowVo2 {
	private String mt20id;	 // 공연ID	PF132236
	private String prfnm;	 // 공연명	우리연애할까
	private String prfpdfrom; // 	공연시작일	2016.05.12
	private String prfpdto;	 // 공연종료일	2016.07.31
	private String fcltynm;	 // 공연시설명(공연장명)	피가로아트홀(구 훈아트홀)
	private String poster;	 // 포스터이미지경로	http://www.kopis.or.kr/upload/pfmPoster/PF_PF132236_160704_142630.gif
	private String genrenm;	 // 공연 장르명	연극
	private String prfstate;	 // 공연상태	공연중
	private char openrun;	 // 오픈런	Y
	
	
	public ShowVo2() {
		// TODO Auto-generated constructor stub
	}

	public ShowVo2(String mt20id, String prfnm, String prfpdfrom, String prfpdto, String fcltynm, String poster,
			String genrenm, String prfstate, char openrun) {
		this.mt20id = mt20id;
		this.prfnm = prfnm;
		this.prfpdfrom = prfpdfrom;
		this.prfpdto = prfpdto;
		this.fcltynm = fcltynm;
		this.poster = poster;
		this.genrenm = genrenm;
		this.prfstate = prfstate;
		this.openrun = openrun;
	}


	public String getMt20id() {
		return mt20id;
	}


	public void setMt20id(String mt20id) {
		this.mt20id = mt20id;
	}


	public String getPrfnm() {
		return prfnm;
	}


	public void setPrfnm(String prfnm) {
		this.prfnm = prfnm;
	}


	public String getPrfpdfrom() {
		return prfpdfrom;
	}


	public void setPrfpdfrom(String prfpdfrom) {
		this.prfpdfrom = prfpdfrom;
	}


	public String getPrfpdto() {
		return prfpdto;
	}


	public void setPrfpdto(String prfpdto) {
		this.prfpdto = prfpdto;
	}


	public String getFcltynm() {
		return fcltynm;
	}


	public void setFcltynm(String fcltynm) {
		this.fcltynm = fcltynm;
	}


	public String getPoster() {
		return poster;
	}


	public void setPoster(String poster) {
		this.poster = poster;
	}


	public String getGenrenm() {
		return genrenm;
	}


	public void setGenrenm(String genrenm) {
		this.genrenm = genrenm;
	}


	public String getPrfstate() {
		return prfstate;
	}


	public void setPrfstate(String prfstate) {
		this.prfstate = prfstate;
	}


	public char getOpenrun() {
		return openrun;
	}


	public void setOpenrun(char openrun) {
		this.openrun = openrun;
	}


	@Override
	public String toString() {
		return "ShowVo2 [mt20id=" + mt20id + ", prfnm=" + prfnm + ", prfpdfrom=" + prfpdfrom + ", prfpdto=" + prfpdto
				+ ", fcltynm=" + fcltynm + ", poster=" + poster + ", genrenm=" + genrenm + ", prfstate=" + prfstate
				+ ", openrun=" + openrun + "]";
	}
	
}

