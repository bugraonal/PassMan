package GUI;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LoginPanel extends JPanel {
	private boolean securityCheck = false;
	private JPasswordField passwordField;
	private GUI gui;
	private JPanel loginPanel;
	
	public LoginPanel(GUI gui) {
		this.gui = gui;
		setBounds(gui.getBounds());
		setOpaque(false);
	}

	public void printLoginPanel() {
		removeAll();
		if (loginPanel == null)
			createLoginPanel();
		add(loginPanel);
}
	
	private void createLoginPanel() {
		loginPanel = new JPanel();
		loginPanel.setBorder(new EmptyBorder(120, 20, 120, 20)); //make this dynamic later
		loginPanel.setLayout(new GridLayout(0, 1, 0, 10));
		
		JLabel enterLabel = new JLabel("Enter your password");
		enterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loginPanel.add(enterLabel);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				passwordCheck(passwordField.getPassword());
			}
		});
		loginPanel.add(passwordField);
	}

	public boolean login(){
		return securityCheck;
	}
	private void passwordCheck(char[] pass){
		
	}
}
