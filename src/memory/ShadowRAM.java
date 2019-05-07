package memory;

public class ShadowRAM extends MemorySpace {
	/*
	Due to the wiring of the GameBoy hardware, an exact copy of the working RAM is available 8k higher in the memory map.
	This copy is available up until the last 512 bytes of the map, where other areas are brought into access.
	(0xE000 - 0xFDFF)
	 */

	public ShadowRAM() {
		data = new int[7679];
		memoryBase = 57344;
	}

	@Override
	public boolean isAddressInMemorySpace(int address) {
		return (address >= 57344 && address <= 65023);
	}
}
