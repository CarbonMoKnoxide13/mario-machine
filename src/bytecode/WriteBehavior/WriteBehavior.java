package bytecode.WriteBehavior;

import cpu.CPU;
import memory.MMU;

import java.util.ArrayList;

public abstract class WriteBehavior {

	int value;

	public void initValue(int value) { //All subclasses will have this init
		this.value = value;
	}
	public abstract void initArgs(ArrayList<Integer> args);
	public abstract void execute(CPU cpu, MMU mmu); //How will I write information to the specified destination?
}
