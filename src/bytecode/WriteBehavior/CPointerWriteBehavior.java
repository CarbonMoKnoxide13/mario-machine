package bytecode.WriteBehavior;

import cpu.CPU;
import memory.MMU;

import java.util.ArrayList;

public class CPointerWriteBehavior extends WriteBehavior {

	private int memoryValue;

	@Override
	public void initArgs(ArrayList<Integer> args) {
		//NO OP
	}

	@Override
	public void execute(CPU cpu, MMU mmu) {
		mmu.setByte(65280 | cpu.getRegister("C"), value);
	}
}
