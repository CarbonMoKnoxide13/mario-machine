package bytecode.Operation;

import bytecode.CopyBehavior.CopyBehavior;
import cpu.CPU;
import memory.MMU;

import java.util.ArrayList;

public class Xor8BitOperation extends Operation {

	public Xor8BitOperation(CopyBehavior leftOperand, CopyBehavior rightOperand) {
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}

	@Override
	public int execute(CPU cpu) { //TODO: Check if this is correct
		int left = leftOperand.execute();
		int right = rightOperand.execute();

		if((left ^ right) == 0) {
			cpu.getRegisterF().setZ(true);
		} else {
			cpu.getRegisterF().setZ(false);
		}

		cpu.getRegisterF().setN(false);
		cpu.getRegisterF().setH(false);
		cpu.getRegisterF().setC(false);

		return (left ^ right);
	}

	@Override
	public void init(ArrayList<Integer> args, CPU cpu, MMU mmu) {
		//Initialize with arguments
		leftOperand.init(args, cpu, mmu);
		rightOperand.init(args, cpu, mmu);
	}

}
