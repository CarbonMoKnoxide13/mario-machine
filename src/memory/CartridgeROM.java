package memory;

public class CartridgeROM extends MemorySpace {
	/*
	CartridgeROM stores cartridge ROM (0x0000 - 0x3FFF for bank 0, 0x4000 - 0x7FFF for other banks) data
	*/

	public CartridgeROM() {
		data = new int[32767];
		memoryBase = 0;
	}

	@Override
	public boolean isAddressInMemorySpace(int address) {
		return (address >= 0 && address <= 32767); //Is the address within the domain of this memory space?
	}

}
