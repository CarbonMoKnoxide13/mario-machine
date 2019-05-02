package bytecode;

import bytecode.CopyBehavior.CopyBehavior;
import cpu.CPU;

public class Load8Bit extends ByteCode {

	CopyBehavior copyBehavior;

	public Load8Bit(String leftArgument, String rightArgument) {
		if(ArgType.is8BitRegister(leftArgument) && ArgType.isD8(rightArgument)) {
			this.argLength = 1; //TODO: Implement ArgType table to get above info
			//copyBehavior = d8CopyBehavior(); //With whatever args are necessary
		} //TODO: Create a d8CopyBehavior subclass of CopyBehavior
	} //TODO: Figure out how to get arguments and store them into copyBehavior

	@Override
	public void execute(CPU cpu) {

	}
}
