package memory;

public class GraphicsRAM extends MemorySpace {
	/*
	Data required for the backgrounds and sprites used by the graphics subsystem is held here,
	and can be changed by the cartridge program.
	(0x8000 - 0x9FFF)
	 */

	public GraphicsRAM() {
		data = new int[8191];
		memoryBase = 32768;
	}

	@Override
	public boolean isAddressInMemorySpace(int address) {
		return (address >= 32768 && address <= 40959);
	}
}
