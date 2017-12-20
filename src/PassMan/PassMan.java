package PassMan;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import GUI.GUIManager;

public class PassMan {
	private GUIManager gui;

	public PassMan() throws SAXException, IOException, ParserConfigurationException, TransformerException {
		gui = new GUIManager();
		gui.printMainPanel();
	}

	public static void main(String[] args) throws Exception {
		// This will be our testbed
		new PassMan();
	}
}
