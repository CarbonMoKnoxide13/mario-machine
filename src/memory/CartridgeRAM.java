package memory;

public class CartridgeRAM extends MemorySpace {
	/*
	There is a small amount of writeable memory available in the GameBoy;
	if a game is produced that requires more RAM than is available in the hardware,
	additional 8k chunks of RAM can be made addressable here.
	(0xA000 - 0xBFFF)
	 */

	public CartridgeRAM() {
		data = new int[8191];
		memoryBase = 40960;
	}

	@Override
	public boolean isAddressInMemorySpace(int address) {
		return (address >= 40960 && address <= 49151);
	}
}
