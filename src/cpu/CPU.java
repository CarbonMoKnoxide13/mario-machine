package cpu;

import bytecode.ByteCode;
import bytecode.ByteCodeFactory;
import bytecode.Load8Bit;
import bytecode.LookupTable;
import memory.Cartridge.Cartridge;
import memory.MMU;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
	private int registerF; //Flags. Should this be abstracted?
	private int registerH;
	private int registerL;
	private int pc;

	/*public CPU() {
		this.pc = 256; //100h
	}*/

	public CPU() {
		File f = new File("sample_files/Tetris (JUE) (V1.1) [!].gb");
		MMU mmu = new MMU(); //TODO: Figure out how to get rid of this
		try{
			int[] romArray = Cartridge.loadFile(f);
			int romIterator = 0;
			while(romIterator < romArray.length) {
				ByteCode bc = ByteCodeFactory.getByteCode(romArray[romIterator]);
				if(bc != null) {
					System.out.println(LookupTable.getCommand(romArray[romIterator]) + " !!!!!!!!!!!!!!!");
					ArrayList<Integer> argList = new ArrayList<>();
					for (int i = 0; i < bc.getArgLength(); i++) {
						argList.add(++romIterator);
						System.out.println(Integer.toHexString(romArray[romIterator]));
					}
					bc.passByteCodeArguments(argList, this, mmu);
					romIterator++;
				} else {
					System.out.println(LookupTable.getCommand(romArray[romIterator]));
					romIterator++;
				}
			}

		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public int readByte(int address) {
		System.out.println("Reading byte");
		return 0;
	}

	public void setRegister(String registerName, int value) {
		switch (registerName) {
			case "A":
				setRegisterA(value);
				break;
			case "B":
				setRegisterB(value);
				break;
			case "C":
				setRegisterC(value);
				break;
			case "D":
				setRegisterD(value);
				break;
			case "E":
				setRegisterE(value);
				break;
			case "H":
				setRegisterH(value);
				break;
			case "L":
				setRegisterL(value);
				break;
		}
	}

	public int getRegister(String registerName) {
		switch (registerName) {
			case "A":
				return getRegisterA();
			case "B":
				return getRegisterB();
			case "C":
				return getRegisterC();
			case "D":
				return getRegisterD();
			case "E":
				return getRegisterE();
			case "F":
				return getRegisterF();
			case "H":
				return getRegisterH();
			case "L":
				return getRegisterL();
			case "AF":
				return getRegisterAF();
			case "BC":
				return getRegisterBC();
			case "DE":
				return getRegisterDE();
			case "HL":
				return getRegisterHL();
			default:
				return 0;
		}
	}

	public void writeByte(int address, int value) {
		System.out.println("Writing byte");
	}

	public void setRegisterA(int value) {
		registerA = value;
	}

	public void setRegisterB(int value) {
		registerB = value;
	}

	public void setRegisterC(int value) {
		registerC = value;
	}

	public void setRegisterD(int value) {
		registerD = value;
	}

	public void setRegisterE(int value) {
		registerE = value;
	}

	public void setRegisterH(int value) {
		registerH = value;
	}

	public void setRegisterL(int value) {
		registerL = value;
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

	public int getRegisterF() {
		return registerF;
	}

	public int getRegisterH() {
		return registerH;
	}

	public int getRegisterL() {
		return registerL;
	}

	public int getRegisterAF() {
		return (registerA << 8 | registerF);
	}

	public int getRegisterBC() {
		return (registerB << 8 | registerC);
	}

	public int getRegisterDE() {
		return (registerD << 8 | registerE);
	}

	public int getRegisterHL() {
		return (registerH << 8 | registerL);
	}
}

