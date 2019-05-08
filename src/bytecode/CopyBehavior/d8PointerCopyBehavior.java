package bytecode.CopyBehavior;

import cpu.CPU;
import memory.MMU;

import java.util.ArrayList;

public class d8PointerCopyBehavior extends CopyBehavior {

	int memoryValue;

	@Override
	public void init(ArrayList<Integer> args, CPU cpu, MMU mmu) {
		if(args.size() >= 1) {
			memoryValue = mmu.getByte(65280 | args.get(0));
		}
	}

	@Override
	public int execute() {
		return memoryValue;
	}
}
