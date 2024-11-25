package domein;

public class Jackpot {

	private Wiel[] wielen;

	public Jackpot() {
		wielen = new Wiel[3];

		for (int i = 0; i < wielen.length; i++) {
			wielen[i] = new Wiel();
		}
	}

	public int[] geefGetallen() {
		int[] getallen = new int[wielen.length];

		for (int i = 0; i < wielen.length; i++) {
			getallen[i] = wielen[i].getGetal();
		}

		return getallen;
	}

	public void speel() {
		for (Wiel wiel : wielen) {
			wiel.draai();
		}
	}

	private boolean threeEquals(int a, int b, int c) {
		return a == b && b == c && a == c;
	}

	private boolean twoEqual(int a, int b, int c) {
		return a == b || b == c || a == c;
	}

	public int geefScore() {
		if (threeEquals(wielen[0].getGetal(), wielen[1].getGetal(), wielen[2].getGetal())) {
			// Alle 3 gelijk

			// Als 9
			if (wielen[0].getGetal() == 9)
				return 50;
			else
				return 10;
		}

		if (twoEqual(wielen[0].getGetal(), wielen[1].getGetal(), wielen[2].getGetal())) {
			// 2 gelijke getallen
			return 5;
		}

		return 0;
	}

}