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
	private boolean securityCheck;
	private JPasswordField passwordField;
	public LoginPanel() {
		securityCheck = false;
		setBorder(new EmptyBorder(100, 20, 100, 20)); //make this dynamic later
		setLayout(new GridLayout(0, 1, 0, 10));
		
		JLabel enterLabel = new JLabel("Enter your password");
		enterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(enterLabel);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				passwordCheck(passwordField.getPassword());
			}
		});
		add(passwordField);
		
	}
	public boolean login(){
		return securityCheck;
	}
	private void passwordCheck(char[] pass){
		
	}
}
