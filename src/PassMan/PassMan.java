package PassMan;

import java.util.logging.Level;
import java.util.logging.Logger;

import GUI.GUIManager;

public class PassMan {
	private static final Logger LOG = Logger.getLogger(PassMan.class.getName());
	private GUIManager gui;

	public PassMan() {
		gui = new GUIManager();
		gui.printLoginPanel();
	}

	public static void main(String[] args) {
		// This will be our testbed
		try {
			new PassMan();
		} catch (Exception e) {
			LOG.log(Level.CONFIG, "Could not set look and feel for the application", e);
		}
	}
}
