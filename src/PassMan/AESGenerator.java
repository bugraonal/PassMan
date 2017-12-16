package PassMan;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.*;
import java.security.SecureRandom;
import java.util.Base64;

public class AESGenerator {
	private SecretKey key;
	private static final String ALGORITHM = "AES";
	
	public AESGenerator(String password) {
		try {
			this.password = password;
			// might add nopadding later on so ill keep try catch for now
		} catch (InvalidKeySpecException | NoSuchAlgorithmException | NoSuchPaddingException e) {
			throw new RuntimeException("oops", e);
		}
	}
	
	public void initRandom() {
		SecureRandom random = SecureRandom.getInstanceStrong();
       	  	KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        	keyGen.init(128, random);
		key = keyGen.generateKey();
	}

	public String encrypt(String pass) {
		initRandom();
		Cipher c = Cipher.getInstance(ALGORITHM);
        	c.init(Cipher.ENCRYPT_MODE, key);
        	byte[] encVal = c.doFinal(pass.getBytes());
        	return Base64.getEncoder().encodeToString(encVal);
	}

	public String decrypt(String encryptedPass) {
		initRandom();
		Cipher c = Cipher.getInstance(ALGORITHM);
       	 	c.init(Cipher.DECRYPT_MODE, key);
       	 	byte[] decodedValue = Base64.getDecoder().decode(encryptedPass);
        	byte[] decValue = c.doFinal(decodedValue);
        	return new String(decValue);
	}
}
