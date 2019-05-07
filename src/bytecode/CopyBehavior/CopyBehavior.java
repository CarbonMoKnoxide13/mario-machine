package bytecode.CopyBehavior;

import cpu.CPU;

import java.util.ArrayList;

public abstract class CopyBehavior {

	int copyDestination; //TODO: Do these need to be registers or can only one be a register or what?
	int source;

	public abstract void init(ArrayList<Integer> args, CPU cpu);
	public abstract int execute(); //Subclasses will execute differently based on parameters
}
