package GUI;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
		contentPanel= new JPanel();
		initFrame();
	}

	private void initFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PassMan");
		setResizable(false);
		setSize(450, 299);
		add(contentPanel);
	}

	public void printLoginPanel() {
		contentPanel = new LoginPanel();
		validate();
	}
	
	// I'm leaving GUI related stuff to Onur
}
