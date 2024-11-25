package domein;

import java.security.SecureRandom;

public class Dobbelsteen {

	private int aantalOgen = 1;
	private static final int MAX_AANTAL_OGEN = 6;
	private SecureRandom random = new SecureRandom(); 
	
	public void rol() {
		aantalOgen = random.nextInt(1,MAX_AANTAL_OGEN + 1); 
	}

	public int getAantalOgen() {
		return aantalOgen;
	}
}