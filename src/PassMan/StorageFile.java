package PassMan;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StorageFile {
	public static final String HEADER = "PassMan";
	public static final byte VERSION = 0x1;

	private File loadedFrom;
	private Map<String, StorageNode> nodes = new ConcurrentHashMap<>();
	private byte[] password;
	private Charset charset = Charset.defaultCharset(); // For blank files

	private StorageFile() {

	}

	public static StorageFile load(File file) throws IOException {
		StorageFile dFile = new StorageFile();
		dFile.loadedFrom = file;
		try (FileInputStream stream = new FileInputStream(file)) {
			byte[] neededHeader = (HEADER + ((char) VERSION)).getBytes(StandardCharsets.US_ASCII);
			byte[] actualHeader = new byte[neededHeader.length];
			stream.read(actualHeader);
			if (!Arrays.equals(neededHeader, actualHeader))
				throw new RuntimeException("Got wrong header!"); // lacking bytes = fail
			byte[] charset = readString(stream);
			String decoded = new String(StandardCharsets.US_ASCII.decode(ByteBuffer.wrap(charset)).array());
			dFile.charset = Charset.forName(decoded); // Fails if invalid
			byte[] masterPassword = new byte[32];
			if (stream.read(masterPassword) != masterPassword.length)
				throw new RuntimeException("Was too short when reading master password!");
			dFile.password = masterPassword;
			byte[] idBytes = readString(stream);
			dFile.nodes.put(new String(dFile.charset.decode(ByteBuffer.wrap(idBytes)).array()),
					new StorageNode(readString(stream)));
		}

		return dFile;
	}

	private static byte[] readString(FileInputStream reader) throws IOException {
		int lengthParsed = reader.read();
		if (lengthParsed == -1)
			throw new RuntimeException("Failed to read length byte! Reached EOF!");
		byte[] value = new byte[lengthParsed];
		int i;
		if ((i = reader.read(value)) != lengthParsed)
			throw new RuntimeException(String.format("Expected %s bytes, got %s!", lengthParsed, i));
		return value;
	}

	public static StorageFile blank() {
		StorageFile file = new StorageFile();
		return file;
	}

	public String getNode(String id) throws Exception {
		if (!nodes.containsKey(id))
			return null;
		StorageNode node = nodes.get(id);
		return StorageUtils.decrypt(node.getValue());
	}

	public void createNode(String id, String value) throws Exception {
		nodes.put(id, new StorageNode(StorageUtils.encrypt(value)));
	}

	public byte[] toBytes() throws IOException {
		try (ByteArrayOutputStream bytes = toByteArrayOutputStream()) {
			return bytes.toByteArray();
		}
	}

	public ByteArrayOutputStream toByteArrayOutputStream() throws IOException {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		bytes.write(HEADER.getBytes());
		bytes.write(VERSION);
		byte[] charsetBytes = charset.name().getBytes(StandardCharsets.US_ASCII);
		bytes.write(charsetBytes.length);
		bytes.write(charsetBytes);
		bytes.write(password);
		for (Map.Entry<String, StorageNode> e : nodes.entrySet()) {
			byte[] id = e.getKey().getBytes(charset);
			bytes.write(id.length);
			bytes.write(id);
			byte[] value = e.getValue().getValue();
			bytes.write(value.length);
			bytes.write(value);
		}
		return bytes;
	}

	public void store(File file) throws IOException {
		if (!file.exists())
			file.createNewFile();
		loadedFrom = file;
		toByteArrayOutputStream().writeTo(new FileOutputStream(file));
	}

	public void deleteNode(String id, String passphrase) {
		nodes.remove(id);
	}

	public Map<String, StorageNode> getNodes() {
		return nodes;
	}

	public void store() throws IOException {
		if (loadedFrom == null)
			throw new FileNotFoundException("No original file found!");
		store(loadedFrom);
	}

	public File getFile() {
		return loadedFrom;
	}
}