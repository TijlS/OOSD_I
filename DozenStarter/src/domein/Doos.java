package domein;

public class Doos {
	private static final String DEFAULT_KLEUR = "rood";
	private static final double DEFAULT_RIBBE = 1.0;

	private static int aantalDozenGemaakt;

	private double lengte;
	private double breedte;
	private double hoogte;
	private String kleur;
	private String code;

	public Doos() {
		this(DEFAULT_RIBBE, DEFAULT_RIBBE, DEFAULT_RIBBE, DEFAULT_KLEUR);
	}

	public Doos(String kleur) {
		this(DEFAULT_RIBBE, DEFAULT_RIBBE, DEFAULT_RIBBE, kleur);
	}

	public Doos(double lengte, double breedte, double hoogte) {
		this(lengte, breedte, hoogte, DEFAULT_KLEUR);
	}

	public Doos(double lengte, double breedte, double hoogte, String kleur) {
		super();
		this.setLengte(lengte);
		this.setBreedte(breedte);
		this.setHoogte(hoogte);
		this.setKleur(kleur);

		Doos.aantalDozenGemaakt = Doos.aantalDozenGemaakt + 1;
		this.stelCodeIn();
	}

	public static int getAantalDozenGemaakt() {
		return aantalDozenGemaakt;
	}

	private void setLengte(double lengte) {
		controleerAfmetingen("Lengte", 0, lengte);
		this.lengte = lengte;
	}

	private void setBreedte(double breedte) {
		controleerAfmetingen("Breedte", 0, breedte);
		this.breedte = breedte;
	}

	private void setHoogte(double hoogte) {
		controleerAfmetingen("Hoogte", 0, hoogte);
		this.hoogte = hoogte;
	}

	private void setKleur(String kleur) {
		if (kleur == null || kleur.isEmpty() || kleur.isBlank())
			throw new IllegalArgumentException("Kleur moet een waarde hebben!");
		this.kleur = kleur;
	}

	private void stelCodeIn() {
		this.code = String.format("D%015d", Doos.aantalDozenGemaakt);
	}

	private void controleerAfmetingen(String afmeting, double minWaarde, double waarde) {
		if (!(waarde > minWaarde))
			throw new IllegalArgumentException(String.format("%s moet groter zijn dan %.0f!", afmeting, minWaarde));
	}

	public double getLengte() {
		return lengte;
	}

	public double getBreedte() {
		return breedte;
	}

	public double getHoogte() {
		return hoogte;
	}

	public String getKleur() {
		return kleur;
	}

	public String getCode() {
		return code;
	}

}
