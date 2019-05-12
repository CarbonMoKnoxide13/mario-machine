package cpu;

public class FlagRegister {

	private int registerF;
	//Z = 7
	//N = 6
	//H = 5
	//C = 4

	public int getRegisterF() {
		return registerF;
	}

	public boolean isZ() {
		return (registerF & (1 << 7)) != 0;
	}

	public boolean isN() {
		return (registerF & (1 << 6)) != 0;
	}

	public boolean isH() {
		return (registerF & (1 << 5)) != 0;
	}

	public boolean isC() {
		return (registerF & (1 << 4)) != 0;
	}

	public void setZ(boolean setting) { //TODO: Do I have to check for byte argument here?
		if(setting) {
			registerF = (registerF | (1 << 7)) & 0xff;
		} else {
			registerF = ~(1 << 7) & registerF & 0xff;
		}
	}

	public void setN(boolean setting) {
		if(setting) {
			registerF = (registerF | (1 << 6)) & 0xff;
		} else {
			registerF = ~(1 << 6) & registerF & 0xff;
		}
	}

	public void setH(boolean setting) {
		if(setting) {
			registerF = (registerF | (1 << 5)) & 0xff;
		} else {
			registerF = ~(1 << 5) & registerF & 0xff;
		}
	}

	public void setC(boolean setting) {
		if(setting) {
			registerF = (registerF | (1 << 4)) & 0xff;
		} else {
			registerF = ~(1 << 4) & registerF & 0xff;
		}
	}

	public void setRegisterF(int registerF) {
		if(registerF >= 0 && registerF <= 0xff){
			this.registerF = registerF & 0xf0;
		}
	}
}
