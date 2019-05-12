package cpu;

public class Helpers {

	public static int getMSB(int word) {
		if(word >= 0 && word <= 0xffff) {
			return word >> 8;
		}
		else {
			System.out.println("Cannot find the MSB of a non-word"); //TODO: Throw an error here
			return 0;
		}
	}

	public static int getLSB(int word) {
		if(word >= 0 && word <= 0xffff) {
			return word & 0xff;
		}
		else {
			System.out.println("Cannot find the LSB of a non-word"); //TODO: Throw an error here
			return 0;
		}
	}

}
