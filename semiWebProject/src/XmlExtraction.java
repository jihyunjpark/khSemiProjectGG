
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlExtraction {

	public void getXmlData(File xmlFile) throws Exception {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
		doc.getDocumentElement().normalize();

		Element root = doc.getDocumentElement();

		NodeList n_list = root.getElementsByTagName("person");
		Element el = null;
		NodeList sub_n_list = null; // sub_n_list
		Element sub_el = null; // sub_el

		Node v_txt = null;
		String value = "";

		String[] tagList = { "name", "age", "job" };

		System.out.println(n_list.getLength());
		System.out.println(tagList.length);

		for (int i = 0; i < n_list.getLength(); i++) {
			el = (Element) n_list.item(i);
			for (int k = 0; k < tagList.length; k++) {
				sub_n_list = el.getElementsByTagName(tagList[k]);
				for (int j = 0; j < sub_n_list.getLength(); j++) {
					sub_el = (Element) sub_n_list.item(j);
					v_txt = sub_el.getFirstChild();
					value = v_txt.getNodeValue();

					System.out.println(sub_el.getNodeName() + "::::value=" + value);
					if (sub_el.getAttributes().getNamedItem("id") != null)
						System.out.println("id=" + sub_el.getAttributes().getNamedItem("id").getNodeValue());
				}
			}

		}
	}

}
