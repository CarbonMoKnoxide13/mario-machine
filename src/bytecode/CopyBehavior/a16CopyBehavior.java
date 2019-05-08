package bytecode.CopyBehavior;

import cpu.CPU;
import memory.MMU;

import java.util.ArrayList;

public class a16CopyBehavior extends CopyBehavior {

	private int msb;
	private int lsb;

	@Override
	public void init(ArrayList<Integer> args, CPU cpu, MMU mmu) {
		if(args.size() >= 2) {
			this.msb = args.get(1);
			this.lsb = args.get(0);
		}
	}

	@Override
	public int execute() {
		return ((msb << 8) | lsb);
	}
}
