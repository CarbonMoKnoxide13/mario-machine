package bytecode;

import bytecode.CopyBehavior.*;
import bytecode.Operation.Add8BitOperation;
import bytecode.WriteBehavior.*;

public class ByteCodeFactory {

	public static ByteCode getByteCode(int opCode) {

		//TODO: Cannot do 16 bit load 0xF8 until ADD and STORE are implemented.
		//TODO: Only 8 bit loads left are codes 0x3A, 0x32, 0x2A, and 0x22. These require DEC and INC.
		//TODO: Must implement extra cycle and PUSH in order to do 16 bit loads 0xC5, 0xD5, 0xE5, 0xF5 (PUSH)
		//TODO: Must implement POP and STORE in order to do 16 bit loads 0xC1, 0xD1, 0xE1, 0xF1 (POP)
		//I HAVE Load, I just renamed it Write and I HAVE store, I just renamed it Copy
		//How to do ALU???
		//ALU byte code with an Operator variable

		switch(opCode) {

			case 1:
				return new Load8Bit(2, new RegisterWriteBehavior("BC"), new a16CopyBehavior());

			case 2:
				return new Load8Bit(0, new PointerWriteBehavior("BC"), new RegisterCopyBehavior("A"));

			case 6:
				return new Load8Bit(1, new RegisterWriteBehavior("B"), new d8CopyBehavior()); //TODO: Improve syntax so this is easier to read

			case 8:
				return new Load8Bit(2, new a16PointerWriteBehavior(), new RegisterCopyBehavior("SP"));

			case 10:
				return new Load8Bit(0, new RegisterWriteBehavior("A"), new PointerCopyBehavior("BC"));

			case 14:
				return new Load8Bit(1, new RegisterWriteBehavior("C"), new d8CopyBehavior());

			case 17:
				return new Load8Bit(2, new RegisterWriteBehavior("DE"), new a16CopyBehavior());

			case 18:
				return new Load8Bit(0, new PointerWriteBehavior("DE"), new RegisterCopyBehavior("A"));

			case 22:
				return new Load8Bit(1, new RegisterWriteBehavior("D"), new d8CopyBehavior());

			case 26:
				return new Load8Bit(0, new RegisterWriteBehavior("A"), new PointerCopyBehavior("DE"));

			case 30:
				return new Load8Bit(1, new RegisterWriteBehavior("E"), new d8CopyBehavior());

			case 33:
				return new Load8Bit(2, new RegisterWriteBehavior("HL"), new a16CopyBehavior());

			case 38:
				return new Load8Bit(1, new RegisterWriteBehavior("H"), new d8CopyBehavior());

			case 46:
				return new Load8Bit(1, new RegisterWriteBehavior("L"), new d8CopyBehavior());

			case 49:
				return new Load8Bit(2, new RegisterWriteBehavior("SP"), new a16CopyBehavior());

			case 54:
				return new Load8Bit(1, new PointerWriteBehavior("HL"), new d8CopyBehavior());

			case 62:
				return new Load8Bit(1, new RegisterWriteBehavior("A"), new d8CopyBehavior());

			case 64:
				return new Load8Bit(0, new RegisterWriteBehavior("B"), new RegisterCopyBehavior("B"));

			case 65:
				return new Load8Bit(0, new RegisterWriteBehavior("B"), new RegisterCopyBehavior("C"));

			case 66:
				return new Load8Bit(0, new RegisterWriteBehavior("B"), new RegisterCopyBehavior("D"));

			case 67:
				return new Load8Bit(0, new RegisterWriteBehavior("B"), new RegisterCopyBehavior("E"));

			case 68:
				return new Load8Bit(0, new RegisterWriteBehavior("B"), new RegisterCopyBehavior("H"));

			case 69:
				return new Load8Bit(0, new RegisterWriteBehavior("B"), new RegisterCopyBehavior("L"));

			case 70:
				return new Load8Bit(0, new RegisterWriteBehavior("B"), new PointerCopyBehavior("HL"));

			case 71:
				return new Load8Bit(0, new RegisterWriteBehavior("B"), new RegisterCopyBehavior("A"));

			case 72:
				return new Load8Bit(0, new RegisterWriteBehavior("C"), new RegisterCopyBehavior("B"));

			case 73:
				return new Load8Bit(0, new RegisterWriteBehavior("C"), new RegisterCopyBehavior("C"));

			case 74:
				return new Load8Bit(0, new RegisterWriteBehavior("C"), new RegisterCopyBehavior("D"));

			case 75:
				return new Load8Bit(0, new RegisterWriteBehavior("C"), new RegisterCopyBehavior("E"));

			case 76:
				return new Load8Bit(0, new RegisterWriteBehavior("C"), new RegisterCopyBehavior("H"));

			case 77:
				return new Load8Bit(0, new RegisterWriteBehavior("C"), new RegisterCopyBehavior("L"));

			case 78:
				return new Load8Bit(0, new RegisterWriteBehavior("C"), new PointerCopyBehavior("HL"));

			case 79:
				return new Load8Bit(0, new RegisterWriteBehavior("C"), new RegisterCopyBehavior("A"));

			case 80:
				return new Load8Bit(0, new RegisterWriteBehavior("D"), new RegisterCopyBehavior("B"));

			case 81:
				return new Load8Bit(0, new RegisterWriteBehavior("D"), new RegisterCopyBehavior("C"));

			case 82:
				return new Load8Bit(0, new RegisterWriteBehavior("D"), new RegisterCopyBehavior("D"));

			case 83:
				return new Load8Bit(0, new RegisterWriteBehavior("D"), new RegisterCopyBehavior("E"));

			case 84:
				return new Load8Bit(0, new RegisterWriteBehavior("D"), new RegisterCopyBehavior("H"));

			case 85:
				return new Load8Bit(0, new RegisterWriteBehavior("D"), new RegisterCopyBehavior("L"));

			case 86:
				return new Load8Bit(0, new RegisterWriteBehavior("D"), new PointerCopyBehavior("HL"));

			case 87:
				return new Load8Bit(0, new RegisterWriteBehavior("D"), new RegisterCopyBehavior("A"));

			case 88:
				return new Load8Bit(0, new RegisterWriteBehavior("E"), new RegisterCopyBehavior("B"));

			case 89:
				return new Load8Bit(0, new RegisterWriteBehavior("E"), new RegisterCopyBehavior("C"));

			case 90:
				return new Load8Bit(0, new RegisterWriteBehavior("E"), new RegisterCopyBehavior("D"));

			case 91:
				return new Load8Bit(0, new RegisterWriteBehavior("E"), new RegisterCopyBehavior("E"));

			case 92:
				return new Load8Bit(0, new RegisterWriteBehavior("E"), new RegisterCopyBehavior("H"));

			case 93:
				return new Load8Bit(0, new RegisterWriteBehavior("E"), new RegisterCopyBehavior("L"));

			case 94:
				return new Load8Bit(0, new RegisterWriteBehavior("E"), new PointerCopyBehavior("HL"));

			case 95:
				return new Load8Bit(0, new RegisterWriteBehavior("E"), new RegisterCopyBehavior("A"));

			case 96:
				return new Load8Bit(0, new RegisterWriteBehavior("H"), new RegisterCopyBehavior("B"));

			case 97:
				return new Load8Bit(0, new RegisterWriteBehavior("H"), new RegisterCopyBehavior("C"));

			case 98:
				return new Load8Bit(0, new RegisterWriteBehavior("H"), new RegisterCopyBehavior("D"));

			case 99:
				return new Load8Bit(0, new RegisterWriteBehavior("H"), new RegisterCopyBehavior("E"));

			case 100:
				return new Load8Bit(0, new RegisterWriteBehavior("H"), new RegisterCopyBehavior("H"));

			case 101:
				return new Load8Bit(0, new RegisterWriteBehavior("H"), new RegisterCopyBehavior("L"));

			case 102:
				return new Load8Bit(0, new RegisterWriteBehavior("H"), new PointerCopyBehavior("HL"));

			case 103:
				return new Load8Bit(0, new RegisterWriteBehavior("H"), new RegisterCopyBehavior("A"));

			case 104:
				return new Load8Bit(0, new RegisterWriteBehavior("L"), new RegisterCopyBehavior("B"));

			case 105:
				return new Load8Bit(0, new RegisterWriteBehavior("L"), new RegisterCopyBehavior("C"));

			case 106:
				return new Load8Bit(0, new RegisterWriteBehavior("L"), new RegisterCopyBehavior("D"));

			case 107:
				return new Load8Bit(0, new RegisterWriteBehavior("L"), new RegisterCopyBehavior("E"));

			case 108:
				return new Load8Bit(0, new RegisterWriteBehavior("L"), new RegisterCopyBehavior("H"));

			case 109:
				return new Load8Bit(0, new RegisterWriteBehavior("L"), new RegisterCopyBehavior("L"));

			case 110:
				return new Load8Bit(0, new RegisterWriteBehavior("L"), new PointerCopyBehavior("HL"));

			case 111:
				return new Load8Bit(0, new RegisterWriteBehavior("L"), new RegisterCopyBehavior("A"));

			case 112:
				return new Load8Bit(0, new PointerWriteBehavior("HL"), new RegisterCopyBehavior("B"));

			case 113:
				return new Load8Bit(0, new PointerWriteBehavior("HL"), new RegisterCopyBehavior("C"));

			case 114:
				return new Load8Bit(0, new PointerWriteBehavior("HL"), new RegisterCopyBehavior("D"));

			case 115:
				return new Load8Bit(0, new PointerWriteBehavior("HL"), new RegisterCopyBehavior("E"));

			case 116:
				return new Load8Bit(0, new PointerWriteBehavior("HL"), new RegisterCopyBehavior("H"));

			case 117:
				return new Load8Bit(0, new PointerWriteBehavior("HL"), new RegisterCopyBehavior("L"));

			case 119:
				return new Load8Bit(0, new PointerWriteBehavior("HL"), new RegisterCopyBehavior("A"));

			case 120:
				return new Load8Bit(0, new RegisterWriteBehavior("A"), new RegisterCopyBehavior("B"));

			case 121:
				return new Load8Bit(0, new RegisterWriteBehavior("A"), new RegisterCopyBehavior("C"));

			case 122:
				return new Load8Bit(0, new RegisterWriteBehavior("A"), new RegisterCopyBehavior("D"));

			case 123:
				return new Load8Bit(0, new RegisterWriteBehavior("A"), new RegisterCopyBehavior("E"));

			case 124:
				return new Load8Bit(0, new RegisterWriteBehavior("A"), new RegisterCopyBehavior("H"));

			case 125:
				return new Load8Bit(0, new RegisterWriteBehavior("A"), new RegisterCopyBehavior("L"));

			case 126:
				return new Load8Bit(0, new RegisterWriteBehavior("A"), new PointerCopyBehavior("HL"));

			case 127:
				return new Load8Bit(0, new RegisterWriteBehavior("A"), new RegisterCopyBehavior("A"));

			case 128:
				return new ALUOperation(0, new Add8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("B")), new RegisterWriteBehavior("A"));

			case 129:
				return new ALUOperation(0, new Add8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("C")), new RegisterWriteBehavior("A"));

			case 130:
				return new ALUOperation(0, new Add8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("D")), new RegisterWriteBehavior("A"));

			case 131:
				return new ALUOperation(0, new Add8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("E")), new RegisterWriteBehavior("A"));

			case 132:
				return new ALUOperation(0, new Add8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("H")), new RegisterWriteBehavior("A"));

			case 133:
				return new ALUOperation(0, new Add8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("L")), new RegisterWriteBehavior("A"));

			case 135:
				return new ALUOperation(0, new Add8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("A")), new RegisterWriteBehavior("A"));

			case 224:
				return new Load8Bit(1, new d8PointerWriteBehavior(), new RegisterCopyBehavior("A"));

			case 226:
				return new Load8Bit(0, new CPointerWriteBehavior(), new RegisterCopyBehavior("A"));

			case 234:
				return new Load8Bit(2, new a16PointerWriteBehavior(), new RegisterCopyBehavior("A"));

			case 240:
				return new Load8Bit(1, new RegisterWriteBehavior("A"), new d8PointerCopyBehavior());

			case 242:
				return new Load8Bit(0, new RegisterWriteBehavior("A"), new CPointerCopyBehavior());

			case 249:
				return new Load8Bit(0, new RegisterWriteBehavior("SP"), new RegisterCopyBehavior("HL"));

			case 250:
				return new Load8Bit(2, new RegisterWriteBehavior("A"), new a16CopyBehavior());

			default:
				return null;
		}
	}
}
