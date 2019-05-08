package bytecode.CopyBehavior;

import cpu.CPU;
import memory.MMU;

import java.util.ArrayList;

public class PointerCopyBehavior extends CopyBehavior {

	private int memoryAddress; //TODO: You have everything you need. Now implement (HL) byte codes
	private String registerName;

	public PointerCopyBehavior(String registerName) {
		this.registerName = registerName;
	}

	@Override
	public void init(ArrayList<Integer> args, CPU cpu, MMU mmu) {
		memoryAddress = mmu.getByte(cpu.getRegister(registerName));
	}

	@Override
	public int execute() {
		return memoryAddress;
	}
}
