package PassMan;

public class StorageUtils {
	public static String decrypt(byte[] toDecrypt) throws Exception {
		AESGenerator dec = new AESGenerator();
		return dec.decrypt(toDecrypt);
	}

	public static byte[] encrypt(String toEncrypt) throws Exception {
		AESGenerator enc = new AESGenerator();
		return enc.encrypt(toEncrypt);
	}
}
