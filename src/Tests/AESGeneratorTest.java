package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import PassMan.AESGenerator;

public class AESGeneratorTest {

	@Test
	public void testEncryption() throws Exception {
		AESGenerator enc = new AESGenerator();

		String testString = "testpass";
		byte[] encryptedPass = enc.encrypt(testString);

		assertEquals(testString, enc.decrypt(encryptedPass));
	}
}
