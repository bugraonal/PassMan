package PassMan;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PreferencesFile {
	Collection<Site> siteList = new ArrayList<Site>();
	private File file = new File("E:\\testpassman.xml"); // change this or give it as an arg
	
	public PreferencesFile() throws ParserConfigurationException, IOException, TransformerException, SAXException { // if no file, create new
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        	DocumentBuilder db = dbf.newDocumentBuilder();            
        	Document document = db.newDocument();
        	Element element = document.createElement("root");
        	document.appendChild(element);
	}
	
	public Document parseFile() throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		DocumentBuilder b = f.newDocumentBuilder();
		Document doc = b.parse(file);

		return doc;
	}

	
	public void updateFile(Document doc) throws IOException, TransformerException {
		DOMSource source = new DOMSource(doc);

        	TransformerFactory transformerFactory = TransformerFactory.newInstance();
        	Transformer transformer = transformerFactory.newTransformer();
        	transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        	transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        	StreamResult result = new StreamResult(file);
        	transformer.transform(source, result);
	}
	
	public void readFile(Document docu) throws SAXException, IOException, ParserConfigurationException { // this is for tests dont use
		Document doc = parseFile();
		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName("site");


		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			System.out.println("\nCurrent Element :" + nNode.getNodeName());
			
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;

			 	// Get the value of all sub-elements.
                 		String url = elem.getElementsByTagName("url")
                                     .item(0).getChildNodes().item(0).getTextContent();

                 		String user = elem.getElementsByTagName("user").item(0)
                                     .getChildNodes().item(0).getTextContent();

                 		String pass = elem.getElementsByTagName("pass")
                                     .item(0).getChildNodes().item(0).getTextContent();


                 		siteList.add(new Site(url, user, pass));

            		}
       		}

	}
	
	
	public void addSite(String url, String user, String pass) throws SAXException, IOException, ParserConfigurationException, TransformerException {
		Document docu = parseFile();
		Element root = docu.getDocumentElement();

		siteList.add(new Site(url, user, pass));
		
		for (Site site : siteList) {
            		Element newSite = docu.createElement("site");
            
            		Element newUrl = docu.createElement("url");
            		newUrl.appendChild(docu.createTextNode(site.getUrl()));
            		newSite.appendChild(newUrl);

            		Element newUser = docu.createElement("user");
            		newUser.appendChild(docu.createTextNode(site.getUser()));
            		newSite.appendChild(newUser);

            		Element newPass = docu.createElement("pass");
            		newPass.appendChild(docu.createTextNode(site.getPass()));
            		newSite.appendChild(newPass);

            		root.appendChild(newSite);
        	}
		
		updateFile(docu);
	}
	
	public static class Site {
		private String url;
		private String user;
		private String pass;
		
		public Site(String url, String user, String pass) {
			this.url = url;
			this.user = user;
			this.pass = pass;
		}
		public String getUrl() { return url; }
        	public String getUser() { return user; }
        	public String getPass() { return pass; }
    }

		
}
