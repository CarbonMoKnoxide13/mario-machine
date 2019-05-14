package bytecode.Operation;

import bytecode.CopyBehavior.CopyBehavior;
import cpu.CPU;
import memory.MMU;

import java.util.ArrayList;

public class Sbc8BitOperation extends Operation {

	public Sbc8BitOperation(CopyBehavior leftOperand, CopyBehavior rightOperand) {
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

		if(((left - right - carry) & 255) == 0) { //How to add carry into this?
			cpu.getRegisterF().setZ(true);
		} else {
			cpu.getRegisterF().setZ(false);
		}

		cpu.getRegisterF().setN(true);

		if(((left ^ right ^ ((left - right - carry) & 255)) & (1 << 4)) != 0) {
			cpu.getRegisterF().setH(true);
		} else {
			cpu.getRegisterF().setH(false);
		}

		if((left - right - carry) < 0) {
			cpu.getRegisterF().setC(true);
		} else {
			cpu.getRegisterF().setC(false);
		}

		return (left - right - carry) & 255;
	}

	@Override
	public void init(ArrayList<Integer> args, CPU cpu, MMU mmu) { //TODO: Seriously consider making this concrete if all subclasses of Operator have the same init() implementation
		leftOperand.init(args, cpu, mmu);
		rightOperand.init(args, cpu, mmu);
	}
}
