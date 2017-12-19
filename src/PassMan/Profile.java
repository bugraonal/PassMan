package PassMan;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Profile {

	private ArrayList<String> domains;
	private ArrayList<Reminder> reminders;
	private StorageFile file;
	
	/*
	 * This constructor should only be used to first initialize the profile
	 */
	public Profile(){
		domains = new ArrayList<String>();
		reminders = new ArrayList<Reminder>();
		file = StorageFile.blank();
	}
	/*
	 * This constructor will be used to recover previously stored profiles
	 * It will take the file as input
	 * As the storage file is not completely implemented this is subject to
	 * changes
	 */
	public Profile(File stored) throws IOException{
		file = StorageFile.load(stored);
	}
	/*
	 * This function will return the corresponding password for the 
	 * given domain
	 * The domain will be chosen from a list, therefore the string input
	 * is used.  
	 */
	public String getPassword(String domain) throws Exception{
		return file.getNode(domain);
	}
	/*
	 * Local interface to write to file
	 * Will be used in GUI
	 */
	public void addPassword(String domain, String pass) throws Exception{
		domains.add(domain);
		file.createNode(domain, pass);
		reminders.add(new Reminder());
	}
	/*
	 * Used to add a new reminder
	 * Inputs are in order:
	 * 	1. The string domain which to add a reminder to
	 * 	2. Amount to be added to the reminder
	 * 	3. The type to be added (ie. months, years, days)
	 */
	public void addReminder(String domain, int amount, String type) throws Exception{
		Reminder rem = new Reminder();
		int idx = findDomain(domain);
		reminders.set(idx, rem);	
		rem.setDueDate(amount, type);
	}
	
	public Reminder getReminder(String domain) throws Exception{
		int idx = findDomain(domain);
		return reminders.get(idx);
	}
	
	private int findDomain(String domain) throws Exception{
		int idx = 0;
		for (;idx < domains.size() + 1; idx++){
			if (domains.get(idx).equals(domain))
				break;
			else if (idx == domains.size() + 1)
				return -1; throw new Exception("Could not find domain");
		}
		return idx;
	}
}
