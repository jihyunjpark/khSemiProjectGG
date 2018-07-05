import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.w3c.dom.Element;

public class test {
	public void test() {
		String baseUrl = "http://aljjabaegi.tistory.com?key=";
		String key = "API키";

		 

		try {
		       SAXBuilder builder = new SAXBuilder();
		       Document doc = builder.build(new java.net.URL(baseUrl+key));
		       Element root = doc.getRootElement();  //result

		        List<Element> list = root.getChildren("record");
		        List<InciVO> inciList = new ArrayList<InciVO>();
		        for(int i=0;i<list.size(); i++){
		             InciVO inciData = new InciVO();
		             Element inci = list.get(i);
		             inciData.setData1(inci.getChildText("data1"));
		             inciData.setData2(inci.getChildText("data2"));

		             inciData.setData3(inci.getChildText("data3"));

		             inciData.setData4(inci.getChildText("data4"));

		             inciData.setData5(inci.getChildText("data5"));
		             inciList.add(inciData);
		        }
		  } catch (Exception e) {
		       e.printStackTrace();
		  }



		출처: http://aljjabaegi.tistory.com/331 [알짜배기 프로그래머]
		
	}
	

}
