package cpu;

public class CPU {
	/*
	Reads Cartridge instructions one by one - should Cartridge have the read method?
	Creates ByteCode subclasses using CodeTable -> Decode
	ReadByte(address) -> Fetch
	WriteByte(address, value)
	ByteCodes implement Strategy to define execution behavior -> Execute
	Has single-byte registers: PC (memory address of next instruction), SP (memory address of top of stack),
		F (flags), A - E & H & L (general purpose registers), ticks (records number of CPU cycles)
	Flags : ZF (Zero Flag - set if the result of the operation is zero); OF (Operation Flag - set if the operation was
		subtraction); HCF (Half Carry Flag - set if there was an overflow in the lower half of the result);
		CF (Carry Flag - set if there was an overflow in the result)
	General purpose registers hold 1 byte, but some can be combined to hold 2
	 */
	private int registerA; //TODO: Abstract this.  Use Registers class with its own Flags class
	private int registerB;
	private int registerC;
	private int registerD;
	private int registerE;
	private int registerH;
	private int registerL;
	private int pc;

	public CPU() {
		this.pc = 256; //100h
	}

	public int readByte(int address) {
		System.out.println("Reading byte");
		return 0;
	}

	public void writeByte(int address, int value) {
		System.out.println("Writing byte");
	}

	public int getPc() {
		return pc;
	}

	public int getRegisterA() {
		return registerA;
	}

	public int getRegisterB() {
		return registerB;
	}

	public int getRegisterC() {
		return registerC;
	}

	public int getRegisterD() {
		return registerD;
	}

	public int getRegisterE() {
		return registerE;
	}

	public int getRegisterH() {
		return registerH;
	}

	public int getRegisterL() {
		return registerL;
	}
}

