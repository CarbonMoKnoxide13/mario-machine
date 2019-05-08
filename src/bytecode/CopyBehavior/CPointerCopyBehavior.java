package bytecode.CopyBehavior;

import cpu.CPU;
import memory.MMU;

import java.util.ArrayList;

public class CPointerCopyBehavior extends CopyBehavior {

	private int memoryValue;

	@Override
	public void init(ArrayList<Integer> args, CPU cpu, MMU mmu) {
		memoryValue = mmu.getByte(65280 | cpu.getRegister("C"));
	}

	@Override
	public int execute() {
		return memoryValue;
	}
}
