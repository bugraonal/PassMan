package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import PassMan.Reminder;

public class ReminderTest {

	@Test
	public void test1(){
		Reminder rem = new Reminder();
		rem.setDueDate(23, "months");
		System.out.println(rem.dispDueDate());
		System.out.println(rem.dispRemainingTime());
	}

}
