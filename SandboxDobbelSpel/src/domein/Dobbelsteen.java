package domein;

import java.security.SecureRandom;

public class Dobbelsteen {

	private int aantalOgen;

	public Dobbelsteen() {
	}

	public int getAantalOgen() {
		return this.aantalOgen;
	}

	public void rol() {
		SecureRandom sr = new SecureRandom();

		this.aantalOgen = sr.nextInt(1, 7);
	}

}