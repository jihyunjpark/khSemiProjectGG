package board.show.controller;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import board.show.model.vo.ShowVo2;

public class ShowListExtXml {

	public List<ShowVo2> getXmlDataSAX(int page, String type) {
		List<ShowVo2> showList = null;
		
		try {
			String baseUrl = "http://www.kopis.or.kr/openApi/restful/pblprfr?service=d11d486f591e447d84737299b2895c19&stdate=20180101&eddate=20190101&cpage=" + page + "&rows=12&prfstate=02&shcate=" + type;
			SAXBuilder builder = new SAXBuilder();
			Document doc = (Document) builder.build(new java.net.URL(baseUrl));
			Element root = doc.getRootElement(); // result

			List<Element> list = root.getChildren("db");
			showList = new ArrayList<ShowVo2>();
			String[] tagList = { "mt20id", "prfnm", "prfpdfrom", "prfpdto", "fcltynm", "poster", "genrenm", "prfstate", "openrun"};
			for (int i = 0; i < list.size(); i++) {
				ShowVo2 showData = new ShowVo2();
				Element th = list.get(i);
				showData.setMt20id(th.getChildText(tagList[0]));
				showData.setPrfnm(th.getChildText(tagList[1]));
				showData.setPrfpdfrom(th.getChildText(tagList[2]));
				showData.setPrfpdto(th.getChildText(tagList[3]));
				showData.setFcltynm(th.getChildText(tagList[4]));
				showData.setPoster(th.getChildText(tagList[5]));
				showData.setGenrenm(th.getChildText(tagList[6]));
				showData.setPrfstate(th.getChildText(tagList[7]));
				showData.setOpenrun(th.getChildText(tagList[8]).charAt(0));
				showList.add(showData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return showList;
	}

}