package PassMan;

import javax.crypto.Mac;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class StorageFile {
	public static final Mac SHA256;
	public static final String HEADER = "PassMan";
	public static final byte VERSION = 0x1;

	static {
		Mac SHA25;
		try {
			SHA25 = Mac.getInstance("HmacSHA256"); // Java Consistency:tm:
													// HmacSHA256 and SHA-256
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			SHA25 = null;
		}
		SHA256 = SHA25;
	}

	private StorageFile() {

	}

	private File load;

	public static StorageFile load(File file) throws IOException {
		StorageFile dFile = new DatabaseFile();
		dFile.load = file;
		// TODO read file with master password and salt
	}

	// TODO get node and set node

}
