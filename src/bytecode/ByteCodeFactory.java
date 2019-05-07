package bytecode;

import bytecode.CopyBehavior.*;
import bytecode.WriteBehavior.*;

public class ByteCodeFactory {

	public static ByteCode getByteCode(int opCode) {

		switch(opCode) {

			case 6:
				return new Load8Bit(1, new RegisterWriteBehavior("B"), new d8CopyBehavior()); //TODO: Improve syntax so this is easier to read

			case 14:
				return new Load8Bit(1, new RegisterWriteBehavior("C"), new d8CopyBehavior());

			case 22:
				return new Load8Bit(1, new RegisterWriteBehavior("D"), new d8CopyBehavior());

			case 30:
				return new Load8Bit(1, new RegisterWriteBehavior("E"), new d8CopyBehavior());

			case 38:
				return new Load8Bit(1, new RegisterWriteBehavior("H"), new d8CopyBehavior());

			case 46:
				return new Load8Bit(1, new RegisterWriteBehavior("L"), new d8CopyBehavior());

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

			default:
				return null;
		}
	}
}
