package bytecode.Operation;

import bytecode.CopyBehavior.CopyBehavior;
import cpu.CPU;

public abstract class Operation {

	CopyBehavior leftOperand;
	CopyBehavior rightOperand;

	public abstract int execute(CPU cpu);
}
