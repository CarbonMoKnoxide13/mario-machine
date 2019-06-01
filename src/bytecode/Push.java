package bytecode;

import bytecode.CopyBehavior.RegisterCopyBehavior;
import bytecode.Operation.Dec16BitOperation;
import bytecode.WriteBehavior.PointerWriteBehavior;
import cpu.CPU;
import memory.MMU;

import java.util.ArrayList;

public class Push extends ByteCode {

	private RegisterCopyBehavior dataSource;
	private PointerWriteBehavior destination;
	private Dec16BitOperation decrement;

	public Push(String dataSourceRegisterName) {
		dataSource = new RegisterCopyBehavior(dataSourceRegisterName);
		destination = new PointerWriteBehavior("SP");
		decrement = new Dec16BitOperation(new RegisterCopyBehavior("SP"));
	}

	@Override
	public void execute(CPU cpu, MMU mmu) {
		decrement.execute(cpu);
		destination.initValue((dataSource.execute() & 0xFF00) >> 8);
		destination.execute(cpu, mmu);
		decrement.execute(cpu);
		destination.initValue((dataSource.execute() & 0x00FF) >> 8);
		destination.execute(cpu, mmu);
	}

	@Override
	public void passByteCodeArguments(ArrayList<Integer> args, CPU cpu, MMU mmu) {
		dataSource.init(args, cpu, mmu);
	}
}
