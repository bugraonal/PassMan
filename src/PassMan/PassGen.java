package PassMan;

import java.security.SecureRandom;

public class PassGen {
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();
	
	public PassGen() {
		
	}
	
	public String generatePassword() {
		StringBuilder sb = new StringBuilder(12);
		for( int i = 0; i < 12; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		return sb.toString();
	}

}
