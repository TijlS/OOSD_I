package domein;

public class Kaart {

	private String kleur;
	private String waarde;

	/**
	 * 
	 * @param waarde
	 * @param kleur
	 */
	public Kaart(String waarde, String kleur) {
		this.waarde = waarde;
		this.kleur = kleur;
	}

	public String getKleur() {
		return this.kleur;
	}

	public String getWaarde() {
		return this.waarde;
	}
}