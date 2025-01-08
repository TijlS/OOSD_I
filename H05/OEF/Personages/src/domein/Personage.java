package domein;

public class Personage {

	private Categorie categorie;
	private String naam;

	private final static String DEFAULT_CATEGORIE = "anoniem";

	/**
	 * 
	 * @param naam
	 * @param categorie
	 */
	public Personage(String naam, Categorie categorie) {
		this.setNaam(naam);
		this.categorie = categorie;
	}

	/**
	 * 
	 * @param naam
	 */
	private void setNaam(String naam) {
		if (naam == null || naam.isBlank() || naam.length() < 3 || naam.length() > 50)
			this.naam = DEFAULT_CATEGORIE;
		this.naam = naam;
	}

	public String getNaam() {
		return this.naam;
	}

	public Categorie getCategorie() {
		return this.categorie;
	}

}