package GUI;

import java.awt.*;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class GUI extends JFrame {

	private GUIManager guiManager;
	private MainPanel mainPanel;
	private LoginPanel loginPanel;
	private NavigationBar navigationBar;
	private JPanel contentPanel;

	public GUI(GUIManager guiManager) {
		this.guiManager = guiManager;
		mainPanel = null;
		loginPanel = null;
		navigationBar = null;
		initFrame();
	}

	private void initFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PassMan");
		setResizable(false);
		setSize(450, 300);
		setVisible(true);
	}

	public void printLoginPanel() {
		getContentPane().removeAll();
		if (loginPanel == null)
			loginPanel = new LoginPanel(this);
		loginPanel.printLoginPanel();
		add(loginPanel);
		getContentPane().repaint();
		getContentPane().validate();
	}
	
	public void printMainPanel() throws SAXException, IOException, ParserConfigurationException, TransformerException {
		getContentPane().removeAll();
		getContentPane().setLayout(new BorderLayout());
		if (navigationBar == null)
			navigationBar = new NavigationBar(this);
		if (mainPanel == null)
			mainPanel = new MainPanel(this);

		getContentPane().add(navigationBar, BorderLayout.NORTH);
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		
		getContentPane().repaint();
		getContentPane().validate();
	}
}
