package PassMan;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import java.security.Key;

public class AESGenerator {
	private static final String ALGORITHM = "AES";
	private static final byte[] keyValue = new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r', 'e', 't',
			'K', 'e', 'y' };

	public AESGenerator() {

	}

	public static Key initRandom() throws Exception {
		Key key = new SecretKeySpec(keyValue, ALGORITHM);
		return key;
	}

	public byte[] encrypt(String pass) throws Exception {
		Key key = initRandom();
		Cipher c = Cipher.getInstance(ALGORITHM);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = c.doFinal(pass.getBytes("UTF-8"));
		return encVal;
	}

	public String decrypt(byte[] encryptedPass) throws Exception {
		Key key = initRandom();
		Cipher c = Cipher.getInstance(ALGORITHM);
		c.init(Cipher.DECRYPT_MODE, key);
		byte[] decValue = c.doFinal(encryptedPass);
		return new String(decValue);
	}
}
