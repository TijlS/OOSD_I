package domein;

public class VerplaatsingPerAuto extends Verplaatsing {
	private static final double MIN_BENZINEPRIJS = 0.5;
	private static final double MAX_BENZINEPRIJS = 2.0;
	private static final double MIN_VERBRUIK = 0.02;
	private static final double MAX_VERBRUIK = 0.07;

	private double benzineprijs;
	private double verbruik;

	public VerplaatsingPerAuto(String van, String naar, double aantalKm, double benzineprijs, double verbruik) {
		super(van, naar, aantalKm);
		this.setBenzineprijs(benzineprijs);
		this.setVerbruik(verbruik);
	}

	public double getBenzineprijs() {
		return benzineprijs;
	}

	public void setBenzineprijs(double benzineprijs) {
		if (MIN_BENZINEPRIJS > benzineprijs || benzineprijs > MAX_BENZINEPRIJS)
			throw new IllegalArgumentException(String.format("Benzineprijs moet in interval [%.2f, %.2f] liggen!",
					MIN_BENZINEPRIJS, MAX_BENZINEPRIJS));
		this.benzineprijs = benzineprijs;
	}

	public double getVerbruik() {
		return verbruik;
	}

	public void setVerbruik(double verbruik) {
		if (MIN_VERBRUIK > verbruik || verbruik > MAX_VERBRUIK)
			throw new IllegalArgumentException(
					String.format("Verbruik moet in interval [%.2f, %.2f] liggen!", MIN_VERBRUIK, MAX_VERBRUIK));
		this.verbruik = verbruik;
	}

	@Override
	public String toString() {
		return String.format("%s per auto", super.toString());
	}

	public double berekenPrijs() {
		return verbruik * benzineprijs * super.getAantalKm() * 2;
	}
}
