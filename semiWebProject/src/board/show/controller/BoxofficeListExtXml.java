package board.show.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import board.show.model.vo.BoxofficeShowVo;
import board.show.model.vo.ShowVo2;

public class BoxofficeListExtXml {
	
	public List<BoxofficeShowVo> getXmlDataSAX(String category, String type) {
		List<BoxofficeShowVo> showList = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date today = new Date();
		String strToday = sdf.format(today);
		
		try {
			String baseUrl = "http://kopis.or.kr/openApi/restful/boxoffice?service=d11d486f591e447d84737299b2895c19&ststype=" + type + "&date=" + strToday + "&catecode=" + category;
			SAXBuilder builder = new SAXBuilder();
			Document doc = (Document) builder.build(new java.net.URL(baseUrl));
			Element root = doc.getRootElement(); // result

			List<Element> list = root.getChildren("boxof");
			showList = new ArrayList<BoxofficeShowVo>();
			String[] tagList = { "area", "prfdtcnt", "prfpd", "cate", "prfplcnm", "prfnm", "rnum", "seatcnt", "poster", "mt20id"};
			for (int i = 0; i < 10; i++) {
				BoxofficeShowVo showData = new BoxofficeShowVo();
				Element show = list.get(i);
				showData.setArea(show.getChildText(tagList[0]));
				showData.setPrfdtcnt(Integer.parseInt(show.getChildText(tagList[1])));
				showData.setPrfpd(show.getChildText(tagList[2]));
				showData.setCate(show.getChildText(tagList[3]));
				showData.setPrfplcnm(show.getChildText(tagList[4]));
				showData.setPrfnm(show.getChildText(tagList[5]));
				showData.setRnum(Integer.parseInt(show.getChildText(tagList[6])));
				showData.setSeatcnt(Integer.parseInt(show.getChildText(tagList[7])));
				showData.setPoster(show.getChildText(tagList[8]));
				showData.setMt20id(show.getChildText(tagList[9]));
				showList.add(showData);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return showList;
	}
	
	public String getBoxofficeDate(String category, String type) {
		String boxDate = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date today = new Date();
		String strToday = sdf.format(today);
		
		try {
			String baseUrl = "http://kopis.or.kr/openApi/restful/boxoffice?service=d11d486f591e447d84737299b2895c19&ststype=" + type + "&date=" + strToday + "&catecode=" + category;
			SAXBuilder builder = new SAXBuilder();
			Document doc = (Document) builder.build(new java.net.URL(baseUrl));
			Element root = doc.getRootElement(); // result
			
			System.out.println(root);

			List<Element> list = root.getChildren("basedate");
				BoxofficeShowVo showData = new BoxofficeShowVo();
				Element show = list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boxDate;
		
	}

}
