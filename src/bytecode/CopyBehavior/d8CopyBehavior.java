package bytecode.CopyBehavior;

import cpu.CPU;
import memory.MMU;

import java.util.ArrayList;

public class d8CopyBehavior extends CopyBehavior {

	//TODO: How to distinguish between single d8 copies and double d8 copies?  How to give a d8CopyBehavior a Regiter to copy to?

	private int passedValue;

	@Override
	public void init(ArrayList<Integer> args, CPU cpu, MMU mmu) {
		if(args.size() >= 1) {
			passedValue = args.get(0);
		}
	}

	@Override
	public int execute() {
		return passedValue;
	}
}
