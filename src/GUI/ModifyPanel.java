package GUI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ModifyPanel extends JPanel {

	public ModifyPanel() {//accept database here
		
		//panel layout
		setLayout(new GridLayout(3, 2, 0, 0)); //grid layout for the side by side 
		setBorder(new EmptyBorder(100, 10, 100, 10));//border so it doesnt go across the entire panel 
		
		//panel elements
		//side by side elements are indented 
		//element above each other are separated by double new lines
		JLabel namePassChangeLabel = new JLabel("Change Password and/or Username");
		add(namePassChangeLabel);
		
			JButton namePassChangeButton = new JButton("Modify");
			add(namePassChangeButton);

			
		JLabel deleteLabel = new JLabel("Delete Credientials");
		add(deleteLabel);
			
			JButton deleteButton = new JButton("Delete");
			add(deleteButton);
		
			
		JLabel reminderLabel = new JLabel("Add new reminder");
		add(reminderLabel);
			
			JButton reminderButton = new JButton("New reminder");
			add(reminderButton);

	}

}
