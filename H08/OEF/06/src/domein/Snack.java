package domein;

public class Snack {
	private Categorie categorie;
	private String naam;

	public Snack(String naam, Categorie categorie) {
		this.setNaam(naam);
		this.setCategorie(categorie);
	}

	public boolean isGezond() {
		if (categorie.equals(Categorie.FRUIT) || categorie.equals(Categorie.GROENTE))
			return true;
		return false;
	}

	private void setNaam(String naam) {
		if (null == naam || naam.isBlank())
			throw new IllegalArgumentException("Naam mag niet leeg zijn!");
		this.naam = naam;
	}

	private void setCategorie(Categorie categorie) {
		if (categorie == null)
			throw new IllegalArgumentException("Categorie moet ingevuld zijn!");

		this.categorie = categorie;
	}

	public String getNaam() {
		return naam;
	}

	public Categorie getCategorie() {
		return categorie;
	}

}
