package PassMan;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.*;
import java.security.SecureRandom;
import java.util.Base64;

public class AESGenerator {
	private SecretKey key;
	private static final String ALGORITHM = "AES";

	public AESGenerator() {
		/*
		 * try {
		 * 
		 * } catch (InvalidKeySpecException | NoSuchAlgorithmException |
		 * NoSuchPaddingException e) { throw new RuntimeException("oops", e); }
		 */

		// might add nopadding later on so ill keep try catch for now
	}

	public void initRandom() {
		try {
			SecureRandom random = SecureRandom.getInstanceStrong();
			KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
			keyGen.init(128, random);
			key = keyGen.generateKey();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("NoAlgorithm Oops!", e);
		}
	}

	public String encrypt(String pass) {
		try {
			initRandom();
			Cipher c = Cipher.getInstance(ALGORITHM);
			c.init(Cipher.ENCRYPT_MODE, key);
			byte[] encVal = c.doFinal(pass.getBytes());
			return Base64.getEncoder().encodeToString(encVal);
		} catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
			throw new RuntimeException("Encryption Error Oops!", e);
		}
	}

	public String decrypt(String encryptedPass) {
		try {
			initRandom();
			Cipher c = Cipher.getInstance(ALGORITHM);
			c.init(Cipher.DECRYPT_MODE, key);
			byte[] decodedValue = Base64.getDecoder().decode(encryptedPass);
			byte[] decValue = c.doFinal(decodedValue);
			return new String(decValue);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			throw new RuntimeException("Decryption Error Oops!", e);
		}
	}
}
