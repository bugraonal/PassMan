package GUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.io.IOException;
import java.util.ArrayList;
import java.awt.GridLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import PassMan.PreferencesFile;
import javax.swing.JList;

public class MainPanel extends JPanel {
	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField urlField;
	private GUI gui;

	public MainPanel(GUI gui) throws SAXException, IOException, ParserConfigurationException, TransformerException { // link
																														// with
																														// database
																														// here
		this.gui = gui;
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.WEST);
		PreferencesFile pref = new PreferencesFile();
		ArrayList<String> urlList = pref.getURLs(pref.readFile());

		DefaultListModel<String> listModel = new DefaultListModel<String>();
		for (int i = 0; i < urlList.size(); i++) {
			listModel.addElement(urlList.get(i));
		}
		panel.setLayout(new BorderLayout(0, 0));
		JList<String> list = new JList<String>();
		list.setBorder(new EmptyBorder(0, 15, 0, 15));
		list.setModel(listModel);

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		panel.add(list);
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				urlField.setText(list.getSelectedValue());
				try {
					usernameField.setText(pref.getUser(list.getSelectedValue(), pref.readFile()));
					passwordField.setText(pref.getPass(list.getSelectedValue(), pref.readFile()));

				} catch (SAXException | IOException | ParserConfigurationException | TransformerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

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
		
		JPanel managementPanel = new ModifyPanel();// link database here too
		tabbedPane.addTab("Management", null, managementPanel, null);

	}
}