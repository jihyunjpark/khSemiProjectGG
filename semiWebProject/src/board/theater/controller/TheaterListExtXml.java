package board.theater.controller;

import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import board.theater.model.vo.TheaterVo;

public class TheaterListExtXml {

	public List<TheaterVo> getXmlDataSAX(int page) {
		List<TheaterVo> theaterList = null;
		
		try {
			String baseUrl = "http://www.kopis.or.kr/openApi/restful/prfplc?service=d11d486f591e447d84737299b2895c19&cpage=" + page +"&rows=10&shprfnmfct=";
			SAXBuilder builder = new SAXBuilder();
			Document doc = (Document) builder.build(new java.net.URL(baseUrl));
			Element root = doc.getRootElement(); // result

			List<Element> list = root.getChildren("db");
			theaterList = new ArrayList<TheaterVo>();
			String[] tagList = { "fcltynm", "mt10id", "mt13cnt", "fcltychartr", "sidonm", "gugunnm", "opende" };
			for (int i = 0; i < list.size(); i++) {
				TheaterVo thData = new TheaterVo();
				Element th = list.get(i);
				thData.setFcltynm(th.getChildText(tagList[0]));
				thData.setMt10id(th.getChildText(tagList[1]));
				thData.setMt13cnt(th.getChildText(tagList[2]));
				thData.setFcltychartr(th.getChildText(tagList[3]));
				thData.setSidonm(th.getChildText(tagList[4]));
				thData.setGugunnm(th.getChildText(tagList[5]));
				thData.setOpende(th.getChildText(tagList[6]));
				theaterList.add(thData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return theaterList;
	}

}