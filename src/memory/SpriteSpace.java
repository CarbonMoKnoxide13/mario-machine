package memory;

public class SpriteSpace extends MemorySpace {
	/*
	Data about the sprites rendered by the graphics chip are held here, including the sprites' positions and attributes.
	(0xFE00 - 0xFE9F)
	 */

	public SpriteSpace() {
		data = new int[159];
		memoryBase = 65024;
	}

	@Override
	public boolean isAddressInMemorySpace(int address) {
		return (address >= 65024 && address <= 65183);
	}
}
