package GUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JSeparator;

public class MainPanel extends JPanel {
	private JTextField usernameField;
	private JTextField passwordField;
	private GUI gui;
	public MainPanel(GUI gui) { //link with database here
		this.gui = gui;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 50, 0, 50));
		add(panel, BorderLayout.WEST);
		
		JList list = new JList();
		panel.add(list);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP); //indented tabs for better visibility
		add(tabbedPane, BorderLayout.CENTER);
		
			JPanel credentialsPanel = new JPanel(); //indented panel elements for better visibility
			credentialsPanel.setBorder(new EmptyBorder(80, 20, 80, 20));
			tabbedPane.addTab("Credentials", null, credentialsPanel, null);
			credentialsPanel.setLayout(new GridLayout(0, 2, 0, 0)); //panel layout
			
				JLabel usernameLabel = new JLabel("Username");
				credentialsPanel.add(usernameLabel);
			
				usernameField = new JTextField();
				usernameField.setEditable(false);
				credentialsPanel.add(usernameField);
				usernameField.setColumns(10);
			
				JLabel passwordLabel = new JLabel("Password");
				credentialsPanel.add(passwordLabel);
			
				passwordField = new JTextField();
				passwordField.setEditable(false);
				credentialsPanel.add(passwordField);
				passwordField.setColumns(10);
			
			
			JPanel managementPanel = new ModifyPanel();//link database here too
			tabbedPane.addTab("Management", null, managementPanel, null);

	}
	public void copyStringToClipboard(String str) { //might be interesting 
		  StringSelection stringSelection = new StringSelection(str);
		  Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		  clipboard.setContents(stringSelection, null);
		}
}