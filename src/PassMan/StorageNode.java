package PassMan;

import java.util.Arrays;

public class StorageNode {
	private int id = 0;
	private final byte[] value;

	public StorageNode(byte[] value) {
		setId(++id);
		this.value = value;
	}

	private void setId(int id) {
		this.id = id;

	}

	int getId() {
		return id;
	}

	byte[] getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		StorageNode that = (StorageNode) o;

		if (id == that.id)
			return false;

		return Arrays.equals(value, that.value);
	}

	@Override
	public String toString() {
		return "DatabaseNode{" + "id=int[" + id + "]" + ", value=aes256(value)[" + value.length + "]" + '}';
	}

}
