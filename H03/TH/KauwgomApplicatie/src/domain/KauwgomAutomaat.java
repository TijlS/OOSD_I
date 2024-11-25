package domain;

public class KauwgomAutomaat {

	private int aantalKauwgomBallen;
	private String kleur;
	private boolean muntIngeworpen;
	private static final int MAX_AANTAL_KAUWGOMBALLEN = 200;

	/**
	 * 
	 * @param aantalKauwgomBallen
	 * @param kleur
	 */
	public KauwgomAutomaat(int aantalKauwgomBallen, String kleur) {
		this.setAantalKauwgomBallen(aantalKauwgomBallen);
		this.setKleur(kleur);
	}

	public int getAantalKauwgomBallen() {
		return this.aantalKauwgomBallen;
	}

	public String getKleur() {
		return this.kleur;
	}

	/**
	 * 
	 * @param kleur
	 */
	public void setKleur(String kleur) {
		if (kleur.equals("rood") || kleur.equals("groen") || kleur.equals("blauw"))
			this.kleur = kleur;
		else
			this.kleur = "rood";
	}

	/**
	 * 
	 * @param kleur
	 */
	public KauwgomAutomaat(String kleur) {
		this(0, kleur);
	}

	public KauwgomAutomaat() {
		this("rood");
	}

	/**
	 * 
	 * @param aantalKauwgomBallen
	 */
	public void setAantalKauwgomBallen(int aantalKauwgomBallen) {
		if (aantalKauwgomBallen >= 0 && aantalKauwgomBallen <= MAX_AANTAL_KAUWGOMBALLEN)
			this.aantalKauwgomBallen = aantalKauwgomBallen;
		else
			this.aantalKauwgomBallen = 0;
	}

	/**
	 * 
	 * @param aantalKauwgomBallen
	 */
	public void vulBij(int aantalKauwgomBallen) {
		if (aantalKauwgomBallen >= 0)
			this.setAantalKauwgomBallen(this.aantalKauwgomBallen + aantalKauwgomBallen);
	}

	public boolean isMuntIngeworpen() {
		return this.muntIngeworpen;
	}

	public void werpMuntIn() {
		this.muntIngeworpen = true;
	}

	public void draaiHendel() {
		if (muntIngeworpen) {
			if (aantalKauwgomBallen != 0) {
				aantalKauwgomBallen--;
			}
			muntIngeworpen = false;

		}
	}

}