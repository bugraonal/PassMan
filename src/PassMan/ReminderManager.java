package PassMan;

import java.util.ArrayList;

public class ReminderManager {

	private ArrayList<Reminder> reminders;
	
	public ReminderManager(){
		
	}
	public void checkAll(){
		for(int i = 0; i<reminders.size();i++){
			if (reminders.get(i).checkDue()){
				//reminder gui
				//password.updatePass()
			}
		}
	}
	/*
	 * This method is used to add a new reminder with due date arguments.
	 * This method should be preferred to directly creating a reminder unless used
	 * for testing.
	 */
	public void addReminder(int amount, String type){
		reminders.add(new Reminder());
		reminders.get(reminders.size()-1).setDueDate(amount, type);
	}
	
	publuc void updateReminder()
}
