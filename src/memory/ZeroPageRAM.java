package memory;

public class ZeroPageRAM extends MemorySpace {
	/*
	A high-speed area of 128 bytes of RAM is available at the top of memory. Oddly, though this is "page" 255
	of the memory, it is referred to as page zero, since most of the interaction between the program and the
	GameBoy hardware occurs through use of this page of memory.
	(0xFF80 - 0xFFFF)
	 */

	public ZeroPageRAM() {
		data = new int[127];
		memoryBase = 65408;
	}

	@Override
	public boolean isAddressInMemorySpace(int address) {
		return (address >= 65408 && address <= 65535);
	}
}
