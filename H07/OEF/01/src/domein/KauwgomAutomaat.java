package domein;

import java.security.SecureRandom;

import utils.Kleur;

public class KauwgomAutomaat extends Automaat {
	public KauwgomAutomaat(int aantalBallen) {
		super(aantalBallen);
	}

	public Kleur bepaalKleur() {
		SecureRandom sr = new SecureRandom();

		int index = sr.nextInt(Kleur.values().length);
		return Kleur.values()[index];
	}

}
