package bytecode.CopyBehavior;

import cpu.CPU;

import java.util.ArrayList;

public class RegisterCopyBehavior extends CopyBehavior{

	//TODO: What is meant by (HL) in the CPU Manual?
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
