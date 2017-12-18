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
}
