package GUIListeners;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import PassMan.ReminderManager;

public class ReminderButtonListener implements ActionListener{
	private ReminderManager manager;
	@Override
	public void actionPerformed(ActionEvent e) {
		operation();
	}

	public void operation(){
		
		manager = new ReminderManager();

		JFrame reminderFrame = new JFrame("Create a reminder");
		reminderFrame.setLayout(new FlowLayout());
		reminderFrame.setSize(350,150);

		JTextField user = new JTextField("User");
		reminderFrame.add(user);
		
		JTextField url = new JTextField("URL");
		reminderFrame.add(url);
		
		String[] typeOptions = {"Days", "Months", "Years"};
		JComboBox<String> dateType = new JComboBox<String>(typeOptions);
		reminderFrame.add(dateType);
		
		
		JTextField amount = new JTextField("Amount");
		reminderFrame.add(amount);
		
		JButton confirm = new JButton("Confirm");
		reminderFrame.add(confirm);
		
		
		confirm.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String type = (String) dateType.getSelectedItem();
				type = type.toLowerCase();
				
				try {
					Integer.parseInt(amount.getText());
				}
				catch (NumberFormatException e){
					JOptionPane.showMessageDialog(null, "Please enter a number");
				}
				int x = Integer.parseInt(amount.getText());
				try {
					manager.addReminder(x, type, user.getText(), url.getText());
				} catch (SAXException | IOException | ParserConfigurationException | TransformerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		reminderFrame.setVisible(true);
	}
}
