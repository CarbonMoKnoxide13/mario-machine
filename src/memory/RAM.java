package memory;

public class RAM extends MemorySpace {
	/*
	The GameBoy's internal 8k of RAM, which can be read from or written to by the CPU.
	(0xC000 - 0xDFFF)
	 */

	public RAM() {
		data = new int[8191];
		memoryBase = 49152;
	}

	@Override
	public boolean isAddressInMemorySpace(int address) {
		return (address >= 49152 && address <= 57343);
	}
}
