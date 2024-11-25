package domein;

import java.security.SecureRandom;

public class Wiel {

	private int getal;

	public int getGetal() {
		return this.getal;
	}

	public void draai() {
		SecureRandom sr = new SecureRandom();
		this.getal = sr.nextInt(0, 11);
	}

}