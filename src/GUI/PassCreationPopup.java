package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import PassMan.PassGen;
import PassMan.PreferencesFile;

public class PassCreationPopup extends JFrame {
	private JPanel panel;
	private JTextField urlField;
	private JTextField usernameField;
	private JTextField passwordField;
	private GUI gui;

	public PassCreationPopup(GUI gui) {
		this.gui = gui;
		setSize(350,150);
		panel = new JPanel(new BorderLayout(5, 5));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
				panel_1.setLayout(new BorderLayout(0, 0));
				JPanel labels = new JPanel(new GridLayout(0, 1, 2, 2));
				panel_1.add(labels, BorderLayout.WEST);
				labels.add(new JLabel("URL", SwingConstants.RIGHT));
				labels.add(new JLabel("Username", SwingConstants.RIGHT));
				labels.add(new JLabel("Password", SwingConstants.RIGHT));
		
				JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
				panel_1.add(controls);
				urlField = new JTextField();
				controls.add(urlField);
				usernameField = new JTextField();
				controls.add(usernameField);
				passwordField = new JTextField();
				passwordField.setEditable(false);
				controls.add(passwordField);
		
		JButton createPass = new JButton("Generate Pass");
		createPass.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PassGen pg = new PassGen();
				String generatedPass = pg.generatePassword();
				passwordField.setText(generatedPass);
			}
		});
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(createPass);
		panel.add(buttonPanel, BorderLayout.SOUTH);
		
		JButton addSite = new JButton("Add Site");
		addSite.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				 String url = urlField.getText();
				 String user = usernameField.getText();
				 String pass = passwordField.getText();
				 PreferencesFile pref = new PreferencesFile();
				 if (urlField.getText().equals("") | usernameField.getText().equals("") | passwordField.getText().equals("")) {
					 JOptionPane.showMessageDialog(new JFrame(), "Enter all textfields and generate pass please", "Dialog", JOptionPane.ERROR_MESSAGE);
					 } else {
							 try {
								pref.addSite(url, user, pass);
							} catch (SAXException | IOException | ParserConfigurationException
									| TransformerException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					 }

			}
		});
		buttonPanel.add(addSite);
		add(panel);
	}

	public void showDialog() {
		JOptionPane.showMessageDialog(this, panel, "login", JOptionPane.QUESTION_MESSAGE);
	}

	public String getUsername() {
		return usernameField.getText();
	}

	public String getPassword() {
		return passwordField.getText();
	}

	public void clean() {// would this increase security?
		usernameField.setText(null);
		passwordField.setText(null);
	}

}
