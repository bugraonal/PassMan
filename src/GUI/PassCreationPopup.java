package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PassCreationPopup extends JFrame {
	private JPanel panel;
	private JTextField usernameField;
	private JPasswordField passwordField;
	
	public PassCreationPopup() {

		panel = new JPanel(new BorderLayout(5, 5));
		    JPanel labels = new JPanel(new GridLayout(0, 1, 2, 2));
		    	labels.add(new JLabel("E-Mail", SwingConstants.RIGHT));
		    	labels.add(new JLabel("Password", SwingConstants.RIGHT));
	    panel.add(labels, BorderLayout.WEST);
	    
		    JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
		    	usernameField = new JTextField();
		    	controls.add(usernameField);
		    	passwordField  = new JPasswordField();
		    	controls.add(passwordField);
	    panel.add(controls, BorderLayout.CENTER);	
	}
	public void showDialog(){
		JOptionPane.showMessageDialog(this, panel, "login", JOptionPane.QUESTION_MESSAGE);
	}
	
	public String getUsername(){
		return usernameField.getText();
	}
	
	public char[] getPassword(){
		return passwordField.getPassword();
	}
	
	public void clean(){//would this increase security? 
		usernameField.setText(null);
		passwordField.setText(null);
	}
	
}
