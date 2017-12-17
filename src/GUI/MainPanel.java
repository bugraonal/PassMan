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

public class MainPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	public MainPanel() { //link with database here
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP); //indented tabs for better visibility
		add(tabbedPane, BorderLayout.CENTER);
		
			JPanel credentialsPanel = new JPanel(); //indented panel elements for better visibility
			credentialsPanel.setBorder(new EmptyBorder(100, 10, 100, 10));
			tabbedPane.addTab("Credentials", null, credentialsPanel, null);
			credentialsPanel.setLayout(new GridLayout(0, 2, 0, 0)); //panel layout
			
				JLabel usernameLabel = new JLabel("New label");
				credentialsPanel.add(usernameLabel);
			
				textField = new JTextField();
				credentialsPanel.add(textField);
				textField.setColumns(10);
			
				JLabel passwordLabel = new JLabel("New label");
				credentialsPanel.add(passwordLabel);
			
				textField_1 = new JTextField();
				credentialsPanel.add(textField_1);
				textField_1.setColumns(10);
			
			
			JPanel panel_1 = new ModifyPanel();//link database here too
			tabbedPane.addTab("Management", null, panel_1, null);
			
		
	}
	public void copyStringToClipboard(String str) { //might be interesting 
		  StringSelection stringSelection = new StringSelection(str);
		  Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		  clipboard.setContents(stringSelection, null);
		}
}