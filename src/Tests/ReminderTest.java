package Tests;

import org.junit.Assert;
import org.junit.Test;

import PassMan.AESGenerator;

public class AESGeneratorTest {

	@Test
	public void testEncryption() throws Exception{
		AESGenerator enc = new AESGenerator();
		
		String testString = "testpass";
		byte[] encryptedPass = enc.encrypt(testString);

		Assert.assertEquals(testString, enc.decrypt(encryptedPass));
	}
}
