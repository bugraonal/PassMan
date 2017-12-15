package PassMan;

import java.util.GregorianCalendar;;

public class Reminder {
	
	private GregorianCalendar creation;
	private GregorianCalendar dueDate;
	private int type;
	private int amount;
	
	public Reminder(){
		creation = new GregorianCalendar();
		dueDate = creation;
		type = GregorianCalendar.DAY_OF_MONTH;
		amount = 1;
	}
	
//	This function will be used to initialize the due date
//	for the password update time
//	It will be called with the amount and type (as in years, months, days)
//	The GUI needs to have a dropdown list for the type options
//	The function will also set the amount and type global variables
//	to enable easier updates
	
	public void setDueDate(int amount, String type){ 
		this.amount = amount;
		if (type.equals("days")){
			this.type = GregorianCalendar.DAY_OF_MONTH;
		}
		else if (type.equals("months")){
			this.type = GregorianCalendar.MONTH;		}
		else if (type.equals("years")){
			this.type = GregorianCalendar.YEAR;
		}
		dueDate.add(this.type, amount);
	}
	/*
	 * This function will be used to update the due date with
	 * the previously used settings
	 * If the user chooses to update with different settings 
	 * the setDueDate function should be used
	 */
	public void update(){
		dueDate.add(type, amount);
	}
	/*
	 * This function will return the remaining time for the next 
	 * reminder in string format.
	 * The structure will be Y:M:D
	 */
	public String dispRemainingTime(){
		//WILL IMPLEMENT THIS
		return "";
	}
}
