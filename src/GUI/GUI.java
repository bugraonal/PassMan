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
		initFrame();
		printLoginPanel();
		invalidate();
		validate();
		repaint();
	}

	private void initFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("PassMan");
		setResizable(false);
		setSize(450, 300);
		contentPanel= new LoginPanel();
		getContentPane().add(contentPanel);
		setVisible(true);
	}

	public void printLoginPanel() {
		contentPanel = new JPanel();
		
	}
}
