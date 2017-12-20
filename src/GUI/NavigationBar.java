package GUI;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NavigationBar extends JPanel{
	private GUI gui;

	public NavigationBar(GUI gui) {
		this.gui = gui;
		setLayout(new BorderLayout(0, 0));
		JMenuBar menubar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem newOption = new JMenuItem("New");
		
		newOption.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new PassCreationPopup(gui).setVisible(true);
				gui.getContentPane().repaint();
				gui.getContentPane().validate();
			}
		});
		
		fileMenu.add(newOption);
		menubar.add(fileMenu);
		add(menubar);
	}

}
