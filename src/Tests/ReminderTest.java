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
		//Tests checking the amount...
		assertEquals(0, rem.setDueDate(0,"days"), "Amount should be greater than 0");
        	assertEquals(0, rem.setDueDate(0,"months"), "Amount should be greater than 0");
        	assertEquals(0, rem.setDueDate(0,"years"), "Amount should be greater than 0");

	}
}
