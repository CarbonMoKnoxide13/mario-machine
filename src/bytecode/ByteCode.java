package bytecode;

import cpu.CPU;
import memory.MMU;

import java.util.ArrayList;

public abstract class ByteCode {
	public int cycles;
	int argLength = 0; //Default

	public int getArgLength() {
		return argLength;
	}

	public abstract void execute(CPU cpu, MMU mmu);
	public abstract void passByteCodeArguments(ArrayList<Integer> args, CPU cpu, MMU mmu);
}
