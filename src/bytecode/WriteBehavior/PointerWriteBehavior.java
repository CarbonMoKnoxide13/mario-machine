package bytecode.WriteBehavior;

import cpu.CPU;
import memory.MMU;

import java.util.ArrayList;

public class PointerWriteBehavior extends WriteBehavior {

	private String registerName;

	public PointerWriteBehavior(String registerName) {
		this.registerName = registerName;
	}

	@Override
	public void initArgs(ArrayList<Integer> args) {
		//NO OP
	}

	@Override
	public void execute(CPU cpu, MMU mmu) {
		mmu.setByte(cpu.getRegister(registerName), value);
	}
}
