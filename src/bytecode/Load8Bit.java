package bytecode;

import bytecode.CopyBehavior.CopyBehavior;
import bytecode.WriteBehavior.WriteBehavior;
import cpu.CPU;
import memory.MMU;

import java.util.ArrayList;

public class Load8Bit extends ByteCode {

	CopyBehavior copyBehavior;
	WriteBehavior writeBehavior;

	public Load8Bit(int argLength, WriteBehavior writeBehavior, CopyBehavior copyBehavior) {
		this.argLength = argLength; //TODO: Implement ArgType table to get above info
		this.copyBehavior = copyBehavior; //Should I pass in the arguments to copyBehavior before I give it to Load8Bit?
		this.writeBehavior = writeBehavior;
	}

	@Override
	public void passByteCodeArguments(ArrayList<Integer> args, CPU cpu, MMU mmu) {
		writeBehavior.initArgs(args); //Initialize writeBehavior args first
		copyBehavior.init(args, cpu, mmu); //Initialize copyBehavior with parameters
		//TODO: Is this the correct order to send args to write and copy?
	} //TODO: Seriously think about how I can remove the need to have access to the cpu

	//Test Comment

	@Override
	public void execute(CPU cpu, MMU mmu) {
		writeBehavior.initValue(copyBehavior.execute());
		writeBehavior.execute(cpu, mmu);
	}
}
