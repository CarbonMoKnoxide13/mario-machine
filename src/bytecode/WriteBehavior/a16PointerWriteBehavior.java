package bytecode.WriteBehavior;

import cpu.CPU;
import memory.MMU;

import java.util.ArrayList;

public class a16PointerWriteBehavior extends WriteBehavior {

	private int msb;
	private int lsb;

	@Override
	public void initArgs(ArrayList<Integer> args) {
		if(args.size() >= 2) {
			this.msb = args.get(1);
			this.lsb = args.get(0);
		}
	}

	@Override
	public void execute(CPU cpu, MMU mmu) {
		mmu.setByte(((msb << 8) | lsb), value);
	}
}
