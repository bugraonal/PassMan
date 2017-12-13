package PassMan;

import java.util.Arrays;

public class StorageNode {
	private final byte[] salt;
	private final byte[] value;

	public StorageNode(byte[] salt, byte[] value) {
		this.salt = salt;
		this.value = value;
	}

	private byte[] getSalt() {
		return salt;
	}

	private byte[] getValue() {
		return value;
	}

	// TODO

}
