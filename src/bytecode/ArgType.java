package bytecode;

public class ArgType {
	public static boolean is8BitRegister(String dataTitle) {

		return (dataTitle.equals("A") || dataTitle.equals("B") || dataTitle.equals("C") || dataTitle.equals("D") ||
				dataTitle.equals("E") || dataTitle.equals("H") || dataTitle.equals("L"));

	}

	//Register to Register loads take no additional arguments
	//One byte (8-bit, 0-255) immediate values take 1 additional argument
	//Two byte (16-bit, 0-65535) immediate values take 2 additional arguments (Little endian)


	public static boolean isD8(String dataTitle) {

		//TODO: What would I have to cast the String to in order to compare it?
		//It is read as a String
		//Cast it as an integer that is less than 16?
		return true;

	}
}
