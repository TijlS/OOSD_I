package domein;

public class Verplaatsing {
	private String van;
	private String naar;
	private double aantalKm;

	public Verplaatsing(String van, String naar, double aantalKm) {
		super();
		this.setVan(van);
		this.setNaar(naar);
		this.setAantalKm(aantalKm);
	}

	public String getVan() {
		return van;
	}

	public void setVan(String van) {
		if (van == null || van.isBlank())
			throw new IllegalArgumentException("Van moet ingevuld zijn!");
		this.van = van;
	}

	public String getNaar() {
		return naar;
	}

	public void setNaar(String naar) {
		if (naar == null || naar.isBlank())
			throw new IllegalArgumentException("Naar moet ingevuld zijn!");
		this.naar = naar;
	}

	public double getAantalKm() {
		return aantalKm;
	}

	public void setAantalKm(double aantalKm) {
		if (aantalKm <= 0)
			throw new IllegalArgumentException("AantalKm moet strikt positief zijn!");
		this.aantalKm = aantalKm;
	}

	@Override
	public String toString() {
		return String.format("verplaatsing van %s naar %s", van, naar);
	}
}
