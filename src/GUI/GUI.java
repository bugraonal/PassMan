package GUI;

import java.awt.*;
import javax.swing.JFrame;

public class GUI extends JFrame {

	private GUIManager guiManager;
	private MainPanel mainPanel;
	private LoginPanel loginPanel;
	private NavigationBar navigationBar;

	public GUI(GUIManager guiManager) {
		this.guiManager = guiManager;
		mainPanel = null;
		loginPanel = null;
		navigationBar = null;
		initFrame();
	}

	private void initFrame() {

	}

	public void printLoginPanel() {
		// Print login
	}

	// I'm leaving GUI related stuff to Onur
}
