package bytecode.Operation;

import bytecode.CopyBehavior.CopyBehavior;
import cpu.CPU;
import memory.MMU;

import java.util.ArrayList;

public class Inc8BitOperation extends Operation {

	//Increment Register n

	CopyBehavior register;

	public Inc8BitOperation(CopyBehavior register) {
		this.register = register;
	}

	@Override
	public int execute(CPU cpu) {
		int argument = register.execute();

		if((argument + 1) == 0) {
			cpu.getRegisterF().setZ(true);
		} else {
			cpu.getRegisterF().setZ(false);
		}

		cpu.getRegisterF().setN(false);

		if((argument + 1) > 15) {
			cpu.getRegisterF().setH(true);
		} else {
			cpu.getRegisterF().setH(false);
		}

		argument++;

		return argument;
	}

	@Override
	public void init(ArrayList<Integer> args, CPU cpu, MMU mmu) {
		//Initialize with arguments
		leftOperand.init(args, cpu, mmu);
		rightOperand.init(args, cpu, mmu);
	}
}
