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
		//setSize(450, 299);
		setDynamicSize();
		setVisible(true);
		add(contentPanel);
	}

	private void setDynamicSize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (screenSize.getWidth() / 4);
		int height = (int) screenSize.getHeight() - getTaskBarHeight() - 300;
		int yPos = 0;
		int xPos = (int) (screenSize.getWidth() - width);
		setBounds(xPos, yPos, width, height);
	}
	
	private int getTaskBarHeight() {
		int taskBarHeight = Toolkit.getDefaultToolkit().getScreenInsets(
				getGraphicsConfiguration()).bottom;
		return taskBarHeight;
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
	
	// I'm leaving GUI related stuff to Onur
}
