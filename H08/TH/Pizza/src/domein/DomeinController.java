package domein;

public class DomeinController {
	private Bestelling bestelling;

	public void plaatsBestelling(int aantalPizzas) {
		bestelling = new Bestelling(aantalPizzas);
	}

	public int geefAantalBesteld() {
		return bestelling.getAantal();
	}

	public boolean geeftRechtOpKorting() {
		return bestelling.geeftRechtOpKorting();
	}
}
