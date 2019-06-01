package bytecode;

import bytecode.CopyBehavior.*;
import bytecode.Operation.*;
import bytecode.WriteBehavior.*;

public class ByteCodeFactory {

	public static ByteCode getByteCode(int opCode) {

		//TODO: Cannot do 16 bit load 0xF8 until ADD and STORE are implemented.
		//TODO: Only 8 bit loads left are codes 0x3A, 0x32, 0x2A, and 0x22. These require DEC and INC.
		//TODO: Must implement POP and STORE in order to do 16 bit loads 0xC1, 0xD1, 0xE1, 0xF1 (POP)
		//TODO: Consider if extra cycle is necessary for PUSH and POP
		//I HAVE Load, I just renamed it Write and I HAVE store, I just renamed it Copy
		//How to do ALU???
		//ALU byte code with an Operator variable

		switch(opCode) {

			case 1:
				return new Load8Bit(2, new RegisterWriteBehavior("BC"), new a16CopyBehavior());

			case 2:
				return new Load8Bit(0, new PointerWriteBehavior("BC"), new RegisterCopyBehavior("A"));

			case 3:
				return new ALUOperation(0, new Inc16BitOperation(new RegisterCopyBehavior("BC")), new RegisterWriteBehavior("BC"));

			case 4:
				return new ALUOperation(0, new Inc8BitOperation(new RegisterCopyBehavior("B")), new RegisterWriteBehavior("B"));

			case 5:
				return new ALUOperation(0, new Dec8BitOperation(new RegisterCopyBehavior("B")), new RegisterWriteBehavior("B"));

			case 6:
				return new Load8Bit(1, new RegisterWriteBehavior("B"), new d8CopyBehavior()); //TODO: Improve syntax so this is easier to read

			case 8:
				return new Load8Bit(2, new a16PointerWriteBehavior(), new RegisterCopyBehavior("SP"));

			case 9:
				return new ALUOperation(0, new Add16BitOperation(new RegisterCopyBehavior("HL"), new RegisterCopyBehavior("BC")), new RegisterWriteBehavior("HL"));

			case 10:
				return new Load8Bit(0, new RegisterWriteBehavior("A"), new PointerCopyBehavior("BC"));

			case 11:
				return new ALUOperation(0, new Dec16BitOperation(new RegisterCopyBehavior("BC")), new RegisterWriteBehavior("BC"));

			case 12:
				return new ALUOperation(0, new Inc8BitOperation(new RegisterCopyBehavior("C")), new RegisterWriteBehavior("C"));

			case 13:
				return new ALUOperation(0, new Dec8BitOperation(new RegisterCopyBehavior("C")), new RegisterWriteBehavior("C"));

			case 14:
				return new Load8Bit(1, new RegisterWriteBehavior("C"), new d8CopyBehavior());

			case 17:
				return new Load8Bit(2, new RegisterWriteBehavior("DE"), new a16CopyBehavior());

			case 18:
				return new Load8Bit(0, new PointerWriteBehavior("DE"), new RegisterCopyBehavior("A"));

			case 19:
				return new ALUOperation(0, new Inc16BitOperation(new RegisterCopyBehavior("DE")), new RegisterWriteBehavior("DE"));

			case 20:
				return new ALUOperation(0, new Inc8BitOperation(new RegisterCopyBehavior("D")), new RegisterWriteBehavior("D"));

			case 21:
				return new ALUOperation(0, new Dec8BitOperation(new RegisterCopyBehavior("D")), new RegisterWriteBehavior("D"));

			case 22:
				return new Load8Bit(1, new RegisterWriteBehavior("D"), new d8CopyBehavior());

			case 25:
				return new ALUOperation(0, new Add16BitOperation(new RegisterCopyBehavior("HL"), new RegisterCopyBehavior("DE")), new RegisterWriteBehavior("HL"));

			case 26:
				return new Load8Bit(0, new RegisterWriteBehavior("A"), new PointerCopyBehavior("DE"));

			case 27:
				return new ALUOperation(0, new Dec16BitOperation(new RegisterCopyBehavior("DE")), new RegisterWriteBehavior("DE"));

			case 28:
				return new ALUOperation(0, new Inc8BitOperation(new RegisterCopyBehavior("E")), new RegisterWriteBehavior("E"));

			case 29:
				return new ALUOperation(0, new Dec8BitOperation(new RegisterCopyBehavior("E")), new RegisterWriteBehavior("E"));

			case 30:
				return new Load8Bit(1, new RegisterWriteBehavior("E"), new d8CopyBehavior());

			case 33:
				return new Load8Bit(2, new RegisterWriteBehavior("HL"), new a16CopyBehavior());

			case 35:
				return new ALUOperation(0, new Inc16BitOperation(new RegisterCopyBehavior("HL")), new RegisterWriteBehavior("HL"));

			case 36:
				return new ALUOperation(0, new Inc8BitOperation(new RegisterCopyBehavior("H")), new RegisterWriteBehavior("H"));

			case 37:
				return new ALUOperation(0, new Dec8BitOperation(new RegisterCopyBehavior("H")), new RegisterWriteBehavior("H"));

			case 38:
				return new Load8Bit(1, new RegisterWriteBehavior("H"), new d8CopyBehavior());

			case 41:
				return new ALUOperation(0, new Add16BitOperation(new RegisterCopyBehavior("HL"), new RegisterCopyBehavior("HL")), new RegisterWriteBehavior("HL"));

			case 43:
				return new ALUOperation(0, new Dec16BitOperation(new RegisterCopyBehavior("HL")), new RegisterWriteBehavior("HL"));

			case 44:
				return new ALUOperation(0, new Inc8BitOperation(new RegisterCopyBehavior("L")), new RegisterWriteBehavior("L"));

			case 45:
				return new ALUOperation(0, new Dec8BitOperation(new RegisterCopyBehavior("L")), new RegisterWriteBehavior("L"));

			case 46:
				return new Load8Bit(1, new RegisterWriteBehavior("L"), new d8CopyBehavior());

			case 49:
				return new Load8Bit(2, new RegisterWriteBehavior("SP"), new a16CopyBehavior());

			case 51:
				return new ALUOperation(0, new Inc16BitOperation(new RegisterCopyBehavior("SP")), new RegisterWriteBehavior("SP"));

			case 52:
				return new ALUOperation(0, new Inc8BitOperation(new PointerCopyBehavior("HL")), new PointerWriteBehavior("HL"));

			case 53:
				return new ALUOperation(0, new Dec8BitOperation(new PointerCopyBehavior("HL")), new PointerWriteBehavior("HL"));

			case 54:
				return new Load8Bit(1, new PointerWriteBehavior("HL"), new d8CopyBehavior());

			case 57:
				return new ALUOperation(0, new Add16BitOperation(new RegisterCopyBehavior("HL"), new RegisterCopyBehavior("SP")), new RegisterWriteBehavior("HL"));

			case 59:
				return new ALUOperation(0, new Dec16BitOperation(new RegisterCopyBehavior("SP")), new RegisterWriteBehavior("SP"));

			case 60:
				return new ALUOperation(0, new Inc8BitOperation(new RegisterCopyBehavior("A")), new RegisterWriteBehavior("A"));

			case 61:
				return new ALUOperation(0, new Dec8BitOperation(new RegisterCopyBehavior("A")), new RegisterWriteBehavior("A"));

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

			case 134:
				return new ALUOperation(0, new Add8BitOperation(new RegisterCopyBehavior("A"), new PointerCopyBehavior("HL")), new RegisterWriteBehavior("A"));

			case 135:
				return new ALUOperation(0, new Add8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("A")), new RegisterWriteBehavior("A"));

			case 136:
				return new ALUOperation(0, new Adc8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("B")), new RegisterWriteBehavior("A"));

			case 137:
				return new ALUOperation(0, new Adc8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("C")), new RegisterWriteBehavior("A"));

			case 138:
				return new ALUOperation(0, new Adc8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("D")), new RegisterWriteBehavior("A"));

			case 139:
				return new ALUOperation(0, new Adc8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("E")), new RegisterWriteBehavior("A"));

			case 140:
				return new ALUOperation(0, new Adc8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("H")), new RegisterWriteBehavior("A"));

			case 141:
				return new ALUOperation(0, new Adc8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("L")), new RegisterWriteBehavior("A"));

			case 142:
				return new ALUOperation(0, new Adc8BitOperation(new RegisterCopyBehavior("A"), new PointerCopyBehavior("HL")), new RegisterWriteBehavior("A"));

			case 143:
				return new ALUOperation(0, new Adc8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("A")), new RegisterWriteBehavior("A"));

			case 144:
				return new ALUOperation(0, new Sub8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("B")), new RegisterWriteBehavior("A"));

			case 145:
				return new ALUOperation(0, new Sub8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("C")), new RegisterWriteBehavior("A"));

			case 146:
				return new ALUOperation(0, new Sub8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("D")), new RegisterWriteBehavior("A"));

			case 147:
				return new ALUOperation(0, new Sub8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("E")), new RegisterWriteBehavior("A"));

			case 148:
				return new ALUOperation(0, new Sub8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("H")), new RegisterWriteBehavior("A"));

			case 149:
				return new ALUOperation(0, new Sub8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("L")), new RegisterWriteBehavior("A"));

			case 150:
				return new ALUOperation(0, new Sub8BitOperation(new RegisterCopyBehavior("A"), new PointerCopyBehavior("HL")), new RegisterWriteBehavior("A"));

			case 151:
				return new ALUOperation(1, new Sub8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("A")), new RegisterWriteBehavior("A"));

			case 152:
				return new ALUOperation(0, new Sbc8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("B")), new RegisterWriteBehavior("A"));

			case 153:
				return new ALUOperation(0, new Sbc8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("C")), new RegisterWriteBehavior("A"));

			case 154:
				return new ALUOperation(0, new Sbc8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("D")), new RegisterWriteBehavior("A"));

			case 155:
				return new ALUOperation(0, new Sbc8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("E")), new RegisterWriteBehavior("A"));

			case 156:
				return new ALUOperation(0, new Sbc8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("H")), new RegisterWriteBehavior("A"));

			case 157:
				return new ALUOperation(0, new Sbc8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("L")), new RegisterWriteBehavior("A"));

			case 158:
				return new ALUOperation(0, new Sbc8BitOperation(new RegisterCopyBehavior("A"), new PointerCopyBehavior("HL")), new RegisterWriteBehavior("A"));

			case 159:
				return new ALUOperation(0, new Sbc8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("A")), new RegisterWriteBehavior("A"));

			case 160:
				return new ALUOperation(0, new And8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("B")), new RegisterWriteBehavior("A"));

			case 161:
				return new ALUOperation(0, new And8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("C")), new RegisterWriteBehavior("A"));

			case 162:
				return new ALUOperation(0, new And8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("D")), new RegisterWriteBehavior("A"));

			case 163:
				return new ALUOperation(0, new And8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("E")), new RegisterWriteBehavior("A"));

			case 164:
				return new ALUOperation(0, new And8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("H")), new RegisterWriteBehavior("A"));

			case 165:
				return new ALUOperation(0, new And8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("L")), new RegisterWriteBehavior("A"));

			case 166:
				return new ALUOperation(0, new And8BitOperation(new RegisterCopyBehavior("A"), new PointerCopyBehavior("HL")), new RegisterWriteBehavior("A"));

			case 167:
				return new ALUOperation(0, new And8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("A")), new RegisterWriteBehavior("A"));

			case 168:
				return new ALUOperation(0, new Xor8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("B")), new RegisterWriteBehavior("A"));

			case 169:
				return new ALUOperation(0, new Xor8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("C")), new RegisterWriteBehavior("A"));

			case 170:
				return new ALUOperation(0, new Xor8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("D")), new RegisterWriteBehavior("A"));

			case 171:
				return new ALUOperation(0, new Xor8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("E")), new RegisterWriteBehavior("A"));

			case 172:
				return new ALUOperation(0, new Xor8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("H")), new RegisterWriteBehavior("A"));

			case 173:
				return new ALUOperation(0, new Xor8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("L")), new RegisterWriteBehavior("A"));

			case 174:
				return new ALUOperation(0, new Xor8BitOperation(new RegisterCopyBehavior("A"), new PointerCopyBehavior("HL")), new RegisterWriteBehavior("A"));

			case 175:
				return new ALUOperation(0, new Xor8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("A")), new RegisterWriteBehavior("A"));

			case 176:
				return new ALUOperation(0, new Or8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("B")), new RegisterWriteBehavior("A"));

			case 177:
				return new ALUOperation(0, new Or8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("C")), new RegisterWriteBehavior("A"));

			case 178:
				return new ALUOperation(0, new Or8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("D")), new RegisterWriteBehavior("A"));

			case 179:
				return new ALUOperation(0, new Or8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("E")), new RegisterWriteBehavior("A"));

			case 180:
				return new ALUOperation(0, new Or8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("H")), new RegisterWriteBehavior("A"));

			case 181:
				return new ALUOperation(0, new Or8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("L")), new RegisterWriteBehavior("A"));

			case 182:
				return new ALUOperation(0, new Or8BitOperation(new RegisterCopyBehavior("A"), new PointerCopyBehavior("HL")), new RegisterWriteBehavior("A"));

			case 183:
				return new ALUOperation(0, new Or8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("A")), new RegisterWriteBehavior("A"));

			case 184:
				return new ALUOperation(0, new Cp8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("B")), new RegisterWriteBehavior("A"));

			case 185:
				return new ALUOperation(0, new Cp8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("C")), new RegisterWriteBehavior("A"));

			case 186:
				return new ALUOperation(0, new Cp8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("D")), new RegisterWriteBehavior("A"));

			case 187:
				return new ALUOperation(0, new Cp8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("E")), new RegisterWriteBehavior("A"));

			case 188:
				return new ALUOperation(0, new Cp8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("H")), new RegisterWriteBehavior("A"));

			case 189:
				return new ALUOperation(0, new Cp8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("L")), new RegisterWriteBehavior("A"));

			case 190:
				return new ALUOperation(0, new Cp8BitOperation(new RegisterCopyBehavior("A"), new PointerCopyBehavior("HL")), new RegisterWriteBehavior("A"));

			case 191:
				return new ALUOperation(0, new Cp8BitOperation(new RegisterCopyBehavior("A"), new RegisterCopyBehavior("A")), new RegisterWriteBehavior("A"));

			case 197:
				return new Push("BC");

			case 198:
				return new ALUOperation(1, new Add8BitOperation(new RegisterCopyBehavior("A"), new d8PointerCopyBehavior()), new RegisterWriteBehavior("A"));

			case 206:
				return new ALUOperation(1, new Adc8BitOperation(new RegisterCopyBehavior("A"), new d8PointerCopyBehavior()), new RegisterWriteBehavior("A"));

			case 213:
				return new Push("DE");

			case 214:
				return new ALUOperation(1, new Sub8BitOperation(new RegisterCopyBehavior("A"), new d8PointerCopyBehavior()), new RegisterWriteBehavior("A"));

			case 222:
				return new ALUOperation(1, new Sbc8BitOperation(new RegisterCopyBehavior("A"), new d8PointerCopyBehavior()), new RegisterWriteBehavior("A"));

			case 224:
				return new Load8Bit(1, new d8PointerWriteBehavior(), new RegisterCopyBehavior("A"));

			case 226:
				return new Load8Bit(0, new CPointerWriteBehavior(), new RegisterCopyBehavior("A"));

			case 229:
				return new Push("HL");

			case 230:
				return new ALUOperation(1, new And8BitOperation(new RegisterCopyBehavior("A"), new d8PointerCopyBehavior()), new RegisterWriteBehavior("A"));

			case 232:
				return new ALUOperation(1, new Add16BitOperation(new RegisterCopyBehavior("SP"), new r8CopyBehavior()), new RegisterWriteBehavior("SP"));

			case 234:
				return new Load8Bit(2, new a16PointerWriteBehavior(), new RegisterCopyBehavior("A"));

			case 238:
				return new ALUOperation(1, new Xor8BitOperation(new RegisterCopyBehavior("A"), new d8CopyBehavior()), new RegisterWriteBehavior("A"));

			case 240:
				return new Load8Bit(1, new RegisterWriteBehavior("A"), new d8PointerCopyBehavior());

			case 242:
				return new Load8Bit(0, new RegisterWriteBehavior("A"), new CPointerCopyBehavior());

			case 245:
				return new Push("AF");

			case 246:
				return new ALUOperation(1, new Or8BitOperation(new RegisterCopyBehavior("A"), new d8PointerCopyBehavior()), new RegisterWriteBehavior("A"));

			case 249:
				return new Load8Bit(0, new RegisterWriteBehavior("SP"), new RegisterCopyBehavior("HL"));

			case 250:
				return new Load8Bit(2, new RegisterWriteBehavior("A"), new a16CopyBehavior());

			case 254:
				return new ALUOperation(1, new Cp8BitOperation(new RegisterCopyBehavior("A"), new d8PointerCopyBehavior()), new RegisterWriteBehavior("A"));

			default:
				return null;
		}
	}
}
