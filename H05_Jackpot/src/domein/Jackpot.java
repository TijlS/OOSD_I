package domein;

public class Jackpot {

	private Wiel[] wielen;

	public Jackpot() {
		wielen = new Wiel[3];

		for (Wiel wiel : wielen) {
			wiel = new Wiel();
		}
	}

	public int[] geefGetallen() {
		// TODO - implement Jackpot.geefGetallen
		throw new UnsupportedOperationException();
	}

	public void speel() {
		// TODO - implement Jackpot.speel
		throw new UnsupportedOperationException();
	}

	public int geefScore() {
		// TODO - implement Jackpot.geefScore
		throw new UnsupportedOperationException();
	}

}