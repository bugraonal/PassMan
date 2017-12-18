package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import PassMan.AESGenerator;

public class AESGeneratorTest {

	@Test
	public void testEncryption(){
		AESGenerator enc = new AESGenerator();
		
		String testString = "testpass";
		byte[] encryptedPass = enc.encrypt(testString);

		assertArrayEquals(testString, enc.decrypt(encryptedPass));
	}
