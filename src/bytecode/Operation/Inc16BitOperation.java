package bytecode.Operation;

import bytecode.CopyBehavior.CopyBehavior;
import cpu.CPU;
import memory.MMU;

import java.util.ArrayList;

public class Inc16BitOperation extends Operation {

	//Increment Register n

	CopyBehavior register;

	public Inc16BitOperation(CopyBehavior register) {
		this.register = register;
	}

	@Override
	public int execute(CPU cpu) {
		int argument = register.execute();

		argument++;

		return argument & 65535;
	}

	@Override
	public void init(ArrayList<Integer> args, CPU cpu, MMU mmu) {
		//Initialize with arguments
		leftOperand.init(args, cpu, mmu);
		rightOperand.init(args, cpu, mmu);
	}
}
