package bytecode.Operation;

import bytecode.CopyBehavior.CopyBehavior;
import cpu.CPU;
import memory.MMU;

import java.util.ArrayList;

public class Adc8BitOperation extends Operation {

	public Adc8BitOperation(CopyBehavior leftOperand, CopyBehavior rightOperand) {
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}

	@Override
	public int execute(CPU cpu) {
		int carry;
		if(cpu.getRegisterF().isC()){
			carry = 1;
		} else{
			carry = 0;
		}

		int left = leftOperand.execute();
		int right = rightOperand.execute();

		if(((left + right + carry) & 255) == 0) { //How to add carry into this?
			cpu.getRegisterF().setZ(true);
		} else {
			cpu.getRegisterF().setZ(false);
		}
		cpu.getRegisterF().setN(false);

		if((left & 15) + (right & 15) + carry > 15) {
			cpu.getRegisterF().setH(true);
		} else {
			cpu.getRegisterF().setH(false);
		}//TODO: Are left and right in the wrong order here?

		if(left + right + carry > 255) {
			cpu.getRegisterF().setC(true);
		} else {
			cpu.getRegisterF().setC(false);
		}

		return (left + right + carry) & 255;//This is different than ADD because you have to add n plus the carry flag
	}

	@Override
	public void init(ArrayList<Integer> args, CPU cpu, MMU mmu) {
		//Initialize with arguments
		leftOperand.init(args, cpu, mmu);
		rightOperand.init(args, cpu, mmu);
	}
}
