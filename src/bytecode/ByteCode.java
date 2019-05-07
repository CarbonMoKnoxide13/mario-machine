package bytecode;

import cpu.CPU;

import java.util.ArrayList;

public abstract class ByteCode {
	public int cycles;
	int argLength = 0; //Default

	public int getArgLength() {
		return argLength;
	}

	public abstract void execute(CPU cpu);
	public abstract void passByteCodeArguments(ArrayList<Integer> args, CPU cpu);
}
