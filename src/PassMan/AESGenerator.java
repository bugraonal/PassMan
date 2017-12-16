package PassMan;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.*;
import java.security.SecureRandom;
import java.util.Base64;

public class AESGenerator {
	private SecretKey key;
	private static final String ALGORITHM = "AES";
	
	public AESGenerator(String password, byte[] salt) {
		try {
			this.salt = salt;
			this.password = password;
			// might add nopadding later on
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

	public String encrypt(byte[] bytes) {
		initRandom();
		Cipher c = Cipher.getInstance(ALGORITHM);
        	c.init(Cipher.ENCRYPT_MODE, key);
        	byte[] encVal = c.doFinal(data.getBytes());
        	return Base64.getEncoder().encodeToString(encVal);
	}

	public String decrypt(byte[] bytes) {
		initRandom();
		Cipher c = Cipher.getInstance(ALGORITHM);
       	 	c.init(Cipher.DECRYPT_MODE, key);
       	 	byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
        	byte[] decValue = c.doFinal(decordedValue);
        	return new String(decValue);
	}
}
