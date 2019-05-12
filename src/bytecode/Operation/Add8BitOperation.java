package bytecode.Operation;

import bytecode.CopyBehavior.CopyBehavior;
import cpu.CPU;

public class Add8BitOperation extends Operation {

	public Add8BitOperation(CopyBehavior leftOperand, CopyBehavior rightOperand) {
		this.leftOperand = leftOperand;
		this.rightOperand = rightOperand;
	}


	@Override
	public int execute(CPU cpu) {
		int left = leftOperand.execute();
		int right = rightOperand.execute();
		if(left == right) {
			cpu.getRegisterF().setZ(true);
		}
		cpu.getRegisterF().setN(false);
		cpu.getRegisterF().setH((left & 15) + (right & 15) > 15); //TODO: Are left and right in the wrong order here?
		cpu.getRegisterF().setC(left + right > 255);
		return (left + right) & 255;
	}
}
