package cui;

import java.security.SecureRandom;

public class VierOpEenRijApp {

	public static void main(String[] args) {
		new VierOpEenRijApp().vulArrayEnControleerOpVierOpEenRij();
	}

	private void vulArrayEnControleerOpVierOpEenRij() {
		// Maken en opvullen van de array karakters
		SecureRandom sr = new SecureRandom();
		char[] karakters = new char[10];
		for (int i = 0; i < karakters.length; i++) {
			karakters[i] = sr.nextBoolean() ? 'X' : 'O';
		}

		// TODO hieronder aanvullen
		// ga na als karakters vier zelfde karakters op rij bevat
		// en verzorg de uitvoer
		toonKarakters(karakters);
		System.out.printf("Deze rij bevat %svier op een rij!", heeft4OpEenRij(karakters) ? "" : "geen ");
	}

	private void toonKarakters(char[] karakters) {
		String resultaat = "De rij karakters: ";

		for (char c : karakters) {
			resultaat += String.format(" %s", c);
		}

		System.out.println(resultaat);
	}

	private boolean heeft4OpEenRij(char[] karakters) {
		char lastChar = ' ';
		int opEenRij = 0;

		for (char c : karakters) {
			if (c == lastChar) {
				if (opEenRij >= 4)
					break;
				opEenRij++;
			} else {
				opEenRij = 1;
				lastChar = c;
			}
		}

		return opEenRij >= 4;
	}

}
