package domein;

public class Voorwerp {
	private final static int MAX_NIVEAU = 10;
	private final static int MAX_GEWICHT = 1000;
	private final static int MIN_GEWICHT = 0;
	private final static int MIN_NIVEAU = 1;
	private final String naam;
	private double gewicht;
	private int niveau;

	public Voorwerp(String naam, double gewicht, int niveau) {
		controleerNaam(naam);

		this.naam = naam;
		setGewicht(gewicht);
		setNiveau(niveau);
	}

	public Voorwerp(String naam, double gewicht) {
		this(naam, gewicht, MIN_NIVEAU);
	}

	private void controleerNaam(String naam) {
		if (naam == null || naam.isBlank())
			throw new IllegalArgumentException("Naam mag niet leeg zijn!");
	}

	public String toString() {
		return String.format("%s %s met gewicht %.3fkg uit niveau %d", this.getClass().getSimpleName(), naam, gewicht,
				niveau);
	}

	public String getNaam() {
		return naam;
	}

	public double getGewicht() {
		return gewicht;
	}

	public int getNiveau() {
		return niveau;
	}

	private void setGewicht(double gewicht) {
		if (gewicht < MIN_GEWICHT || gewicht >= MAX_GEWICHT)
			throw new IllegalArgumentException(
					String.format("Gewicht moet in interval [%d, %d[ liggen!", MIN_GEWICHT, MAX_GEWICHT));
		this.gewicht = gewicht;
	}

	private void setNiveau(int niveau) {
		if (niveau < MIN_NIVEAU || niveau > MAX_NIVEAU)
			throw new IllegalArgumentException(
					String.format("Niveau moet in interval [%d, %d] liggen!", MIN_NIVEAU, MAX_NIVEAU));
		this.niveau = niveau;
	}

}
