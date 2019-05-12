package bytecode;

import bytecode.Operation.Operation;
import bytecode.WriteBehavior.WriteBehavior;
import cpu.CPU;
import memory.MMU;

import java.util.ArrayList;

public class ALUOperation extends ByteCode {

	Operation aluCommand;
	WriteBehavior destination;

	public ALUOperation(int argLength, Operation aluCommand, WriteBehavior destination) {
		this.argLength = argLength; //TODO: Implement ArgType table to get above info
		this.aluCommand = aluCommand; //Should I pass in the arguments to copyBehavior before I give it to Load8Bit?
		this.destination = destination;
	}

	@Override
	public void execute(CPU cpu, MMU mmu) {
		destination.initValue(aluCommand.execute(cpu));
		destination.execute(cpu, mmu);
	}

	@Override
	public void passByteCodeArguments(ArrayList<Integer> args, CPU cpu, MMU mmu) {
		//Figure out how to pass ByteCode arguments to Operators
	}
}
