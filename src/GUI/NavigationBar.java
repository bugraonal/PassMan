package GUI;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class NavigationBar extends JPanel{
	private GUI gui;

	public NavigationBar(GUI gui) {
		this.gui = gui;
		setLayout(new BorderLayout(0, 0));
		JMenuBar menubar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem newOption = new JMenuItem("New");
		fileMenu.add(newOption);
		menubar.add(fileMenu);
		add(menubar);
	}

}
