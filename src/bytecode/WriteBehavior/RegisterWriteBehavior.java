package bytecode.WriteBehavior;

import cpu.CPU;

public class RegisterWriteBehavior extends WriteBehavior{

	public RegisterWriteBehavior(String registerName) {
		this.destination = registerName;
	}

	@Override
	public void execute(CPU cpu) {
		//Write to a specific register.
		//I'll probably use some sort of setRegister(String registerName, int value) method.
		cpu.setRegister(destination, value); //Write to corresponding register
	}
}
