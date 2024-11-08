package domein;

public class DomeinController {

	private Spel spel;

	public void startNieuwSpel() {
		this.spel = new Spel();
	}

	public void rolDobbelstenen() {
		spel.rolDobbelstenen();
	}

	public int geefAantalOgenWorp() {
		return this.spel.geefAantalOgenWorp();
	}

	public int geefScore() {
		return spel.getScore();
	}

	public boolean isEindeSpel() {
		return spel.isEindeSpel();
	}

}