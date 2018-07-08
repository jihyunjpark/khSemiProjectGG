package board.show.model.vo;

import java.util.Arrays;

public class ShowDetailVo {
	private String mt20id;	//공연ID	PF132236
	private String mt10id;	//공연시설ID	FC001431
	private String prfnm;	//공연명	우리연애할까
	private String prfpdfrom;	//공연시작일	2016.05.12
	private String prfpdto;	//공연종료일	2016.07.31
	private String fcltynm;	//공연시설명(공연장명)	피가로아트홀(구 훈아트홀) (피가로아트홀)
	private String prfcast;	//공연출연진	김부연, 임정균, 최수영
	private String prfcrew;	//공연제작진	천정민
	private String prfruntime;	//공연 런타임	1시간 30분
	private String prfage;	//공연 관람 연령	만 12세 이상
	private String entrpsnm;	//제작사	극단 피에로
	private String pcseguidance;	//티켓가격	전석 30,000원
	private String poster;	//포스터이미지경로	http://www.kopis.or.kr/upload/pfmPoster/PF_PF132236_160704_142630.gif
	private String sty;	//줄거리	
	private String genrenm;	//장르	연극
	private String prfstate;	//공연상태	공연중
	private String openrun;	//오픈런	Y
	private String[] styurls;	//소개이미지목록	
	private String dtguidance;	//공연시간	화요일 ~ 금요일(20:00), 토요일(16:00,19:00), 일요일(15:00,18:00)
	
	public ShowDetailVo() {
	}
	
	public ShowDetailVo(String mt20id, String mt10id, String prfnm, String prfpdfrom, String prfpdto, String fcltynm,
			String prfcast, String prfcrew, String prfruntime, String prfage, String entrpsnm, String pcseguidance,
			String poster, String sty, String genrenm, String prfstate, String openrun, String[] styurls,
			String dtguidance) {
		this.mt20id = mt20id;
		this.mt10id = mt10id;
		this.prfnm = prfnm;
		this.prfpdfrom = prfpdfrom;
		this.prfpdto = prfpdto;
		this.fcltynm = fcltynm;
		this.prfcast = prfcast;
		this.prfcrew = prfcrew;
		this.prfruntime = prfruntime;
		this.prfage = prfage;
		this.entrpsnm = entrpsnm;
		this.pcseguidance = pcseguidance;
		this.poster = poster;
		this.sty = sty;
		this.genrenm = genrenm;
		this.prfstate = prfstate;
		this.openrun = openrun;
		this.styurls = styurls;
		this.dtguidance = dtguidance;
	}

	public String getMt20id() {
		return mt20id;
	}

	public void setMt20id(String mt20id) {
		this.mt20id = mt20id;
	}

	public String getMt10id() {
		return mt10id;
	}

	public void setMt10id(String mt10id) {
		this.mt10id = mt10id;
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

	public String getPrfcast() {
		return prfcast;
	}

	public void setPrfcast(String prfcast) {
		this.prfcast = prfcast;
	}

	public String getPrfcrew() {
		return prfcrew;
	}

	public void setPrfcrew(String prfcrew) {
		this.prfcrew = prfcrew;
	}

	public String getPrfruntime() {
		return prfruntime;
	}

	public void setPrfruntime(String prfruntime) {
		this.prfruntime = prfruntime;
	}

	public String getPrfage() {
		return prfage;
	}

	public void setPrfage(String prfage) {
		this.prfage = prfage;
	}

	public String getEntrpsnm() {
		return entrpsnm;
	}

	public void setEntrpsnm(String entrpsnm) {
		this.entrpsnm = entrpsnm;
	}

	public String getPcseguidance() {
		return pcseguidance;
	}

	public void setPcseguidance(String pcseguidance) {
		this.pcseguidance = pcseguidance;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getSty() {
		return sty;
	}

	public void setSty(String sty) {
		this.sty = sty;
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

	public String getOpenrun() {
		return openrun;
	}

	public void setOpenrun(String openrun) {
		this.openrun = openrun;
	}

	public String[] getStyurls() {
		return styurls;
	}

	public void setStyurls(String[] styurls) {
		this.styurls = styurls;
	}

	public String getDtguidance() {
		return dtguidance;
	}

	public void setDtguidance(String dtguidance) {
		this.dtguidance = dtguidance;
	}

	@Override
	public String toString() {
		return "ShowDetailVo [mt20id=" + mt20id + ", mt10id=" + mt10id + ", prfnm=" + prfnm + ", prfpdfrom=" + prfpdfrom
				+ ", prfpdto=" + prfpdto + ", fcltynm=" + fcltynm + ", prfcast=" + prfcast + ", prfcrew=" + prfcrew
				+ ", prfruntime=" + prfruntime + ", prfage=" + prfage + ", entrpsnm=" + entrpsnm + ", pcseguidance="
				+ pcseguidance + ", poster=" + poster + ", sty=" + sty + ", genrenm=" + genrenm + ", prfstate="
				+ prfstate + ", openrun=" + openrun + ", styurls=" + Arrays.toString(styurls) + ", dtguidance="
				+ dtguidance + "]";
	}
	
}

