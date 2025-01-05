package domein;

import java.security.SecureRandom;

public class GrijpKraan extends Automaat {
	public GrijpKraan(int aantalPrijzen) {
		super(aantalPrijzen);
	}

	@Override
	public boolean draaiHendel() {
		SecureRandom sr = new SecureRandom();

		boolean gewonnen = sr.nextBoolean();

		if (gewonnen) {
			return super.draaiHendel();
		} else {
			return false;
		}

	}
}
