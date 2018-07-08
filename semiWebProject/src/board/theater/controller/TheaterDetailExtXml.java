package board.theater.controller;

import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import board.theater.model.vo.TheaterDetailVo;

public class TheaterDetailExtXml {

	public TheaterDetailVo getXmlDataSAX(String theaterId) {
		TheaterDetailVo theaterData = null;
		try {
			String baseUrl = "http://www.kopis.or.kr/openApi/restful/prfplc/"+ theaterId + "?service=d11d486f591e447d84737299b2895c19";
			SAXBuilder builder = new SAXBuilder();
			Document doc = (Document) builder.build(new java.net.URL(baseUrl));
			Element root = doc.getRootElement(); // result

			List<Element> list = root.getChildren("db");
			theaterData = new TheaterDetailVo();
			String[] tagList = { "fcltynm", "mt10id", "mt13cnt", "fcltychartr", "opende", "seatscale", "telno", "relateurl", "adres", "la", "lo"};
			Element theater = list.get(0);
			theaterData.setFcltynm(theater.getChildText(tagList[0]));
			theaterData.setMt10id(theater.getChildText(tagList[1]));
			theaterData.setMt13cnt(Integer.parseInt(theater.getChildText(tagList[2])));
			theaterData.setFcltychartr(theater.getChildText(tagList[3]));
			theaterData.setOpende(Integer.parseInt(theater.getChildText(tagList[4])));
			theaterData.setSeatscale(Integer.parseInt(theater.getChildText(tagList[5])));
			theaterData.setTelno(theater.getChildText(tagList[6]));
			theaterData.setRelateurl(theater.getChildText(tagList[7]));
			theaterData.setAdres(theater.getChildText(tagList[8]));
			theaterData.setLa(Double.parseDouble(theater.getChildText(tagList[9])));
			theaterData.setLo(Double.parseDouble(theater.getChildText(tagList[10])));
			return theaterData;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return theaterData;
	}

}