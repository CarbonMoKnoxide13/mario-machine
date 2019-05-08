package bytecode.WriteBehavior;

import cpu.CPU;
import memory.MMU;

import java.util.ArrayList;

public class RegisterWriteBehavior extends WriteBehavior{

	private String destination;

	public RegisterWriteBehavior(String registerName) {
		this.destination = registerName;
	}

	@Override
	public void initArgs(ArrayList<Integer> args) {
		//NO OP
	}

	@Override
	public void execute(CPU cpu, MMU mmu) {
		//Write to a specific register.
		//I'll probably use some sort of setRegister(String registerName, int value) method.
		cpu.setRegister(destination, value); //Write to corresponding register
	}
}
