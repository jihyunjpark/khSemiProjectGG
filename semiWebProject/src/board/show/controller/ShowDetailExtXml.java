package board.show.controller;

import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import board.show.model.vo.ShowDetailVo;

public class ShowDetailExtXml {

	public ShowDetailVo getXmlDataSAX(String showId) {
		ShowDetailVo showData = null;

		try {
			String baseUrl = "http://www.kopis.or.kr/openApi/restful/pblprfr/" + showId
					+ "?service=d11d486f591e447d84737299b2895c19";
			SAXBuilder builder = new SAXBuilder();
			Document doc = (Document) builder.build(new java.net.URL(baseUrl));
			Element root = doc.getRootElement(); // result

			List<Element> list = root.getChildren("db");
			List<Element> subList = list.get(0).getChildren("styurls").get(0).getChildren("styurl");
			showData = new ShowDetailVo();
			String[] tagList = { "mt20id", "mt10id", "prfnm", "prfpdfrom", "prfpdto", "fcltynm", "prfcast", "prfcrew",
					"prfruntime", "prfage", "entrpsnm", "pcseguidance", "poster", "sty", "genrenm", "prfstate",
					"openrun", "styurls", "dtguidance" };
			String[] subTagList = { "styurl" };
			Element show = list.get(0);
			String[] styurls = new String[subList.size()];
			showData.setMt20id(show.getChildText(tagList[0]));
			showData.setMt10id(show.getChildText(tagList[1]));
			showData.setPrfnm(show.getChildText(tagList[2]));
			showData.setPrfpdfrom(show.getChildText(tagList[3]));
			showData.setPrfpdto(show.getChildText(tagList[4]));
			showData.setFcltynm(show.getChildText(tagList[5]));
			showData.setPrfcast(show.getChildText(tagList[6]));
			showData.setPrfcrew(show.getChildText(tagList[7]));
			showData.setPrfruntime(show.getChildText(tagList[8]));
			showData.setPrfage(show.getChildText(tagList[9]));
			showData.setEntrpsnm(show.getChildText(tagList[10]));
			showData.setPcseguidance(show.getChildText(tagList[11]));
			showData.setPoster(show.getChildText(tagList[12]));
			showData.setSty(show.getChildText(tagList[13]));
			showData.setGenrenm(show.getChildText(tagList[14]));
			showData.setPrfstate(show.getChildText(tagList[15]));
			showData.setOpenrun(show.getChildText(tagList[16]));
			for (int j = 0; j < subList.size(); j++) {
				Element url = subList.get(j);
				styurls[j] = url.getValue();
			}
			showData.setStyurls(styurls);
			showData.setDtguidance(show.getChildText(tagList[18]));
			return showData;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return showData;
	}

}