package memory.Cartridge;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import bytecode.LookupTable;
import cpu.CPU;
import org.apache.commons.io.IOUtils;

public class Cartridge {
	/*
	Loaded at runtime
	Must expose an interface that allows other classes to retrieve byte code instructions
	Holds ROM file (.gb file format)
	 */

	public static int[] loadFile(File file) throws IOException {
		InputStream is = new FileInputStream(file);
		return load(is, (int)file.length());
	}

	private static int[] load(InputStream is, int length) throws IOException {
		byte[] byteArray = IOUtils.toByteArray(is, length);
		int[] intArray = new int[byteArray.length];
		for (int i = 0; i < byteArray.length; i++) {
			intArray[i] = byteArray[i] & 0xff;
		}
		return intArray;
	}

	public static void main(String args[]) {
		CPU cpu = new CPU();
	}

	/*
	We are performing BITWISE operations!  That means that to combine register A and B, we can do this:
	A << 8 | B
	 */
}
