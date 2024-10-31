package domein;

public class Tankstation {
	private int[] pompen;

	public Tankstation() {
		pompen = new int[5];
		for (int i = 0; i < pompen.length; i++) {
			pompen[i] = 100;
		}
	}

	public boolean tank(int pompNummer, int aantalLiter) {
		if ((pompNummer >= 1 && pompNummer <= 5) && (aantalLiter >= 5 && aantalLiter <= 80)) {
			if (pompen[pompNummer - 1] >= aantalLiter) {
				pompen[pompNummer - 1] = pompen[pompNummer - 1] - aantalLiter;
				return true;
			}
		}

		return false;
	}

	public int geefInhoud(int pompNummer) {
		if ((pompNummer >= 1 && pompNummer <= 5)) {
			return pompen[pompNummer - 1];
		}

		return -1;
	}

	public String toString() {
		String resultaat = "";
		for (int i = 0; i < pompen.length; i++) {
			resultaat += String.format("Pomp #%d: %d liter%n", i + 1, pompen[i]);
		}
		return resultaat;
	}

}
