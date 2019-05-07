package bytecode.CopyBehavior;

import cpu.CPU;

import java.util.ArrayList;

public class RegisterCopyBehavior extends CopyBehavior{

	//TODO: Record any operations that have to do with (HL) so you can implement them after the address space is implemented
	//Byte Codes needed to implement that use (HL): 7Eh, 46h, 4Eh, 56h, ...
	//(HL) means "access the byte at the location pointed to by the HL register"
	String registerName;
	int registerValue;

	public RegisterCopyBehavior(String registerName) {
		this.registerName = registerName;
	}

	@Override
	public void init(ArrayList<Integer> args, CPU cpu) {
		registerValue = cpu.getRegister(registerName);
	}

	@Override
	public int execute() {
		return registerValue;
	}
}
