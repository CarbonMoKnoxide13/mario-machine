package bytecode.Operation;

import bytecode.CopyBehavior.CopyBehavior;
import cpu.CPU;
import memory.MMU;

import java.util.ArrayList;

public abstract class Operation {

	CopyBehavior leftOperand;
	CopyBehavior rightOperand;

	public abstract int execute(CPU cpu);
	public abstract void init(ArrayList<Integer> args, CPU cpu, MMU mmu);
}
