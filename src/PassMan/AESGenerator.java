package PassMan;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.NoSuchPaddingException;

public class AESGenerator {

	public AESGenerator(String password, byte[] salt) {
		try {
			// keyspec, encrypt/decrypt cipher, secretkey
		} catch (InvalidKeySpecException | NoSuchAlgorithmException | NoSuchPaddingException e) {
			throw new RuntimeException("oops", e);
		}
	}

	public byte[] encrypt(byte[] bytes) {
		// TODO
	}

	public byte[] decrypt(byte[] bytes) {
		// TODO
	}
}
