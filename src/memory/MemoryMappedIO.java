package memory;

public class MemoryMappedIO extends MemorySpace {
	/*
	Each of the GameBoy's subsystems (graphics, sound, etc.) has control values, to allow programs to
	create effects and use the hardware. These values are available to the CPU directly on the address bus,
	in this area.
	(0xFF00 - 0xFF7F)
	 */

	public MemoryMappedIO() {
		data = new int[127];
		memoryBase = 65280;
	}

	@Override
	public boolean isAddressInMemorySpace(int address) {
		return (address >= 65280 && address <= 65407);
	}
}
