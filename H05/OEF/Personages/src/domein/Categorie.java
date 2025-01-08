package domein;

public class Categorie {

	private String omschrijving;
	private int kracht;
	private int snelheid;
	private int lenigheid;
	private final String DEFAULT_OMSCRIJVING = "anoniem";
	private final int MIN_KRACHT = 1;
	private final int MAX_KRACHT = 10;
	private final int MIN_LENIGHEID = 1;
	private final int MAX_LENIGHEID = 10;
	private final int MIN_SNELHEID = 1;

	public Categorie(String omschrijving, int kracht, int snelheid, int lenigheid) {
		this.setOmschrijving(omschrijving);
		this.setKracht(kracht);
		this.setSnelheid(snelheid);
		this.setLenigheid(lenigheid);
	}

	/**
	 * 
	 * @param omschrijving
	 */
	private void setOmschrijving(String omschrijving) {
		if (omschrijving == null || omschrijving.isBlank() || omschrijving.length() > 100)
			this.omschrijving = DEFAULT_OMSCRIJVING;

		this.omschrijving = omschrijving;
	}

	/**
	 * 
	 * @param kracht
	 */
	private void setKracht(int kracht) {
		if (kracht < MIN_KRACHT || kracht > MAX_KRACHT)
			this.kracht = MIN_KRACHT;
		this.kracht = kracht;
	}

	/**
	 * 
	 * @param snelheid
	 */
	private void setSnelheid(int snelheid) {
		if (snelheid <= 0)
			this.snelheid = MIN_SNELHEID;

		this.snelheid = snelheid;
	}

	/**
	 * 
	 * @param lenigheid
	 */
	private void setLenigheid(int lenigheid) {
		if (lenigheid < MIN_LENIGHEID || lenigheid > MAX_LENIGHEID)
			this.lenigheid = MIN_LENIGHEID;
		this.lenigheid = lenigheid;
	}

	public String getOmschrijving() {
		return this.omschrijving;
	}

	public int getKracht() {
		return this.kracht;
	}

	public int getSnelheid() {
		return this.snelheid;
	}

	public int getLenigheid() {
		return this.lenigheid;
	}

}