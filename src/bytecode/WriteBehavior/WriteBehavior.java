package bytecode.WriteBehavior;

import cpu.CPU;

public abstract class WriteBehavior {

	String destination;
	int value;

	public void initValue(int value) { //All subclasses will have this init
		this.value = value;
	}
	public abstract void execute(CPU cpu); //How will I write information to the specified destination?
}
