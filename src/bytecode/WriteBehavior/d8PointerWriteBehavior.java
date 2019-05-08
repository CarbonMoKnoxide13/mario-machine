package bytecode.WriteBehavior;

import cpu.CPU;
import memory.MMU;

import java.util.ArrayList;

public class d8PointerWriteBehavior extends WriteBehavior {

	private int argValue;

	@Override
	public void initArgs(ArrayList<Integer> args) {
		if(args.size() >= 1) {
			this.argValue = args.get(0);
		}
	}

	@Override
	public void execute(CPU cpu, MMU mmu) {
		mmu.setByte(65280 | argValue, value);
	}
}
