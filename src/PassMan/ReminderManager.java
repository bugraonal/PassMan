package PassMan;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import PassMan.PreferencesFile.Site;

public class ReminderManager extends PreferencesFile{

	private ArrayList<Reminder> reminders;
	
	public ReminderManager(){
		setFile(new File("passmanremindersdb.xml"));
	}
	public void checkAll(){
		for(int i = 0; i<reminders.size();i++){
			if (reminders.get(i).checkDue()){
				//reminder gui
				//password.updatePass()
			}
		}
	}
	/*
	 * This method is used to add a new reminder with due date arguments.
	 * This method should be preferred to directly creating a reminder unless used
	 * for testing.
	 */
	public void addReminder(int amount, String type, String user, String url) throws SAXException, IOException, ParserConfigurationException, TransformerException{
		reminders.add(new Reminder(url, user));
		reminders.get(reminders.size()-1).setDueDate(amount, type);
		Document docu = parseFile();
		Element root = docu.getDocumentElement();

		for (Reminder rem : reminders) {
			Element newRem = docu.createElement("reminder");

			Element newDate = docu.createElement("date");
			newDate.appendChild(docu.createTextNode(rem.dispDueDate()));
			newRem.appendChild(newDate);

			Element newUser = docu.createElement("user");
			newUser.appendChild(docu.createTextNode(rem.getUser()));
			newRem.appendChild(newUser);

			Element newUrl = docu.createElement("url");
			newUrl.appendChild(docu.createTextNode(rem.getUrl()));
			newRem.appendChild(newUrl);

			root.appendChild(newRem);
		}

		updateFile(docu);
	}
	
	public ArrayList<Reminder> getReminders() throws ParseException, SAXException, IOException, ParserConfigurationException, TransformerException{
		reminders = new ArrayList<Reminder>();
		Document doc = parseFile();
		doc.getDocumentElement().normalize();

		NodeList nList = doc.getElementsByTagName("reminder");

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);

			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element elem = (Element) nNode;

				// Get the value of all sub-elements.
				String url = elem.getElementsByTagName("url").item(0).getChildNodes().item(0).getTextContent();

				String user = elem.getElementsByTagName("user").item(0).getChildNodes().item(0).getTextContent();

				String date = elem.getElementsByTagName("date").item(0).getChildNodes().item(0).getTextContent();

				reminders.add(new Reminder(user, url, date));
			}
		}
		return reminders;
	}
}
