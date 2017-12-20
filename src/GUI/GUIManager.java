package GUI;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class GUIManager {
	private GUI gui;

	public GUIManager() {
		this.gui = new GUI(this);
	}

	public void printLoginPanel() {
		gui.printLoginPanel();
		
	}

	public void printMainPanel() throws SAXException, IOException, ParserConfigurationException, TransformerException {
		gui.printMainPanel();
	}

}
