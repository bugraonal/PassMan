package Tests;

import org.junit.Assert;
import org.junit.Test;
import PassMan.Reminder;


public class ReminderTest {

	@Test
	public void testReminder(){
		Reminder rem = new Reminder();
		rem.setDueDate(3, "years");
		
		System.out.println(rem.dispDueDate());
		System.out.println(rem.dispRemainingTime());
	}
}
