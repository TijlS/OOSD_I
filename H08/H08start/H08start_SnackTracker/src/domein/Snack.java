package domein;

public class Snack {
	private Categorie categorie;
	private String naam;

	/**
	 * Class constructor. Een nieuwe <code>Snack</code> heeft een <code>naam</code>
	 * en een <code>Categorie</code>.<br>
	 * Beide moeten ingevuld zijn en de naam mag niet enkel uit spaties bestaan.
	 * 
	 * @param naam      een <code>String</code> met de naam voor de nieuwe
	 *                  <code>Snack</code>
	 * @param categorie een <code>Categorie</code> met de categorie voor de nieuwe
	 *                  <code>Snack</code>
	 * @throws IllegalArgumentException wanneer de naam en/of de categorie niet
	 *                                  voldoen
	 */
	public Snack(String naam, Categorie categorie) {
		// TODO
		throw new UnsupportedOperationException();
	}

	/**
	 * Snacks van de categorie FRUIT of GROENTE zijn gezond. Andere snacks zijn
	 * ongezond.
	 * 
	 * @returns een boolean die aangeeft of deze snack al dan niet gezond is
	 */
	public boolean isGezond() {
		// TODO - implement Resultatenlijst
		throw new UnsupportedOperationException();
	}

	private void setNaam(String naam) {
		// TODO - implement Resultatenlijst
		throw new UnsupportedOperationException();
	}

	private void setCategorie(Categorie categorie) {
		// TODO - implement Resultatenlijst
		throw new UnsupportedOperationException();
	}

	public String getNaam() {
		return naam;
	}

	public Categorie getCategorie() {
		return categorie;
	}

}
