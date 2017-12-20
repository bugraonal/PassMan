package GUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;

public class MainPanel extends JPanel {
	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField urlField;
	private GUI gui;

	public MainPanel(GUI gui) { // link with database here
		this.gui = gui;
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 50, 0, 50));
		add(panel, BorderLayout.WEST);

		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		panel.add(list);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP); // indented
																	// tabs for
																	// better
																	// visibility
		add(tabbedPane, BorderLayout.CENTER);

		JPanel credentialsPanel = new JPanel(); // indented panel elements for
		// better visibility
		credentialsPanel.setBorder(new EmptyBorder(80, 20, 80, 20));
		tabbedPane.addTab("Credentials", null, credentialsPanel, null);
		credentialsPanel.setLayout(new GridLayout(0, 2, 0, 0)); // panel layout

		JLabel urlLabel = new JLabel("URL");
		credentialsPanel.add(urlLabel);

		urlField = new JTextField();
		urlField.setEditable(false);
		urlField.setColumns(10);
		credentialsPanel.add(urlField);

		JLabel usernameLabel = new JLabel("Username");
		credentialsPanel.add(usernameLabel);

		usernameField = new JTextField();
		usernameField.setEditable(false);
		usernameField.setColumns(10);
		credentialsPanel.add(usernameField);

		JLabel passwordLabel = new JLabel("Password");
		credentialsPanel.add(passwordLabel);

		passwordField = new JTextField();
		passwordField.setEditable(false);
		credentialsPanel.add(passwordField);
		passwordField.setColumns(10);
		/*
		 * JButton createPass = new JButton("Generate Pass");
		 * createPass.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { PassGen pg =
		 * new PassGen(); String generatedPass = pg.generatePassword();
		 * passwordField.setText(generatedPass); } });
		 * credentialsPanel.add(createPass);
		 * 
		 * JButton addSite = new JButton("Add Site");
		 * addSite.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { String url =
		 * urlField.getText(); String user = usernameField.getText(); String
		 * pass = passwordField.getText(); PreferencesFile pref = new
		 * PreferencesFile(); if (urlField.getText().equals("") |
		 * usernameField.getText().equals("") |
		 * passwordField.getText().equals("")) {
		 * JOptionPane.showMessageDialog(new JFrame(),
		 * "Enter all textfields and generate pass please", "Dialog",
		 * JOptionPane.ERROR_MESSAGE); } else {
		 * 
		 * try { pref.addSite(url, user, pass); } catch (SAXException |
		 * IOException | ParserConfigurationException | TransformerException e1)
		 * { // TODO Auto-generated catch block e1.printStackTrace(); } } } });
		 * 
		 * credentialsPanel.add(addSite);
		 */
		JPanel managementPanel = new ModifyPanel();// link database here too
		tabbedPane.addTab("Management", null, managementPanel, null);

	}

	public void copyStringToClipboard(String str) { // might be interesting
		StringSelection stringSelection = new StringSelection(str);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}
}