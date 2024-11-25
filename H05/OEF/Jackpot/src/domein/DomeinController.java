package domein;

public class DomeinController {

	private Jackpot jackpot;

	public void startNieuweJackpot() {
		jackpot = new Jackpot();
	}

	public int[] geefGetallen() {
		return jackpot.geefGetallen();
	}

	public void speel() {
		jackpot.speel();
	}

	public int geefScore() {
		return jackpot.geefScore();
	}

}