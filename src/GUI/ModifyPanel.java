package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import GUIListeners.ReminderButtonListener;
import PassMan.PreferencesFile;

public class ModifyPanel extends JPanel {

	public ModifyPanel() {//accept database here
		
		//panel layout
		setLayout(new GridLayout(3, 2, 0, 0)); //grid layout for the side by side 
		setBorder(new EmptyBorder(80, 20, 80, 20));//border so it doesnt go across the entire panel 
		
		//panel elements
		//side by side elements are indented 
		//element above each other are separated by double new lines
		JLabel namePassChangeLabel = new JLabel("Edit Credentials");
		add(namePassChangeLabel);
		
			JButton namePassChangeButton = new JButton("Modify");
			namePassChangeButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
						
				}
			});
			add(namePassChangeButton);

			
		JLabel deleteLabel = new JLabel("Delete Credentials");
		add(deleteLabel);
			
			JButton deleteButton = new JButton("Delete");
			deleteButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						new PreferencesFile().newFile();
					} catch (Exception e1) {
						e1.printStackTrace();
					} 			
				}
			});
			add(deleteButton);
		
			
		JLabel reminderLabel = new JLabel("Add new reminder");
		add(reminderLabel);
			
			JButton reminderButton = new JButton("New reminder");
			reminderButton.addActionListener(new ReminderButtonListener());
			add(reminderButton);

	}

}
