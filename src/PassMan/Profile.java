package PassMan;

import java.util.ArrayList;

public class Profile {

	private ArrayList<String> encryptedPasswords;
	private ArrayList<Reminder> reminders;
	
	/*
	 * This constructor should only be used to first initialize the profile
	 */
	public Profile(){
		encryptedPasswords = new ArrayList<String>();
		reminders = new ArrayList<Reminder>();
	}
	/*
	 * This constructor will be used to recover previously stored profiles
	 * It will take the file as input
	 * As the storage file is not completely implemented this is subject to
	 * changes
	 */
	public Profile(StorageFile stored){
		//TODO
	}
	/*
	 * This function will return the corresponding password for the 
	 * given domain
	 * The domain will be chosen from a list, therefore the string input
	 * is used. However if the GUI design involves sorted order (same as 
	 * the arrayList) the string input may be replaced with an integer index
	 * input. 
	 */
	public String getPassword(String domain){
		
		return "";
	}
	
}
