package bytecode.Operation;

import bytecode.CopyBehavior.CopyBehavior;
import cpu.CPU;
import memory.MMU;

import java.util.ArrayList;

public class Add16BitOperation extends Operation {

	public Add16BitOperation(CopyBehavior leftOperand, CopyBehavior rightOperand) {
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}

	@Override
	public int execute(CPU cpu) {
		int left = leftOperand.execute();
		int right = rightOperand.execute();

		cpu.getRegisterF().setN(false);

		if((left & 4094) + (right & 4095) > 4095) {
			cpu.getRegisterF().setH(true);
		} else {
			cpu.getRegisterF().setH(false);
		}//TODO: Are left and right in the wrong order here?

		if(left + right > 65535) {
			cpu.getRegisterF().setC(true);
		} else {
			cpu.getRegisterF().setC(false);
		}

		return (left + right) & 65535;
	}

	@Override
	public void init(ArrayList<Integer> args, CPU cpu, MMU mmu) {
		//Initialize with arguments
		leftOperand.init(args, cpu, mmu);
		rightOperand.init(args, cpu, mmu);
	}
}
