package memory;

public abstract class MemorySpace {

	protected int[] data;
	protected int memoryBase;

	public abstract boolean isAddressInMemorySpace(int address);

	public void setByte(int address, int value) { //TODO: Abstract this so that ROM cannot be written to
		data[address - memoryBase] = value;
	}

	public int getByte(int address) {
		return data[address - memoryBase];
	}
}
