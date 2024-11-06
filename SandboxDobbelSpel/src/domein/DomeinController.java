package domein;

public class DomeinController {

	private Spel spel;

	public void startNieuwSpel() {
		this.spel = new Spel();
	}

	public void rolDobbelstenen() {
		// TODO - implement DomeinController.rolDobbelstenen
		throw new UnsupportedOperationException();
	}

	public int geefAantalOgenWorp() {
		return this.spel.geefAantalOgenWorp();
	}

	public int geefScore() {
		// TODO - implement DomeinController.geefScore
		throw new UnsupportedOperationException();
	}

}