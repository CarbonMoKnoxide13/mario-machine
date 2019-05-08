package memory;

import java.util.ArrayList;

public class MMU {
	/*
	Holds memory
	Stores code and data
	Has methods for fetching and writing to memory
	Has an ArrayList of MemorySpaces
	*/

	ArrayList<MemorySpace> memoryBus = new ArrayList<>();

	public MMU() {
		memoryBus.add(new CartridgeROM());
		memoryBus.add(new GraphicsRAM());
		memoryBus.add(new CartridgeRAM());
		memoryBus.add(new RAM());
		memoryBus.add(new ShadowRAM());
		memoryBus.add(new SpriteSpace());
		memoryBus.add(new ZeroPageRAM());
	}
	
	public int getByte(int address) {
		for (MemorySpace segment: memoryBus) {
			if(segment.isAddressInMemorySpace(address)) {
				return segment.getByte(address);
			}
		}
		return 0; //This should never happen
	}

	public void setByte(int address, int value) {
		for(MemorySpace segment: memoryBus) {
			if(segment.isAddressInMemorySpace(address)) {
				segment.setByte(address, value);
			}
		}
	}
}
