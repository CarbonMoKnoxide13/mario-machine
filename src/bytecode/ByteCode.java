package bytecode;

import cpu.CPU;

public abstract class ByteCode {
	public int cycles;
	int argLength;
	public abstract void execute(CPU cpu);
}
