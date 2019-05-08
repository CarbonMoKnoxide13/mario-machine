package bytecode.CopyBehavior;

import cpu.CPU;
import memory.MMU;

import java.util.ArrayList;

public abstract class CopyBehavior {

	public abstract void init(ArrayList<Integer> args, CPU cpu, MMU mmu);
	public abstract int execute(); //Subclasses will execute differently based on parameters
}
