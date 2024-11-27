package domein;

public class Kapitaal {
	public static final double MIN_BEDRAG = 0, MIN_INTREST = 0, MAX_INTREST = 100;
	private double bedrag, intrest;

	public Kapitaal(double bedrag, double intrest) {
		setBedrag(bedrag);
		setIntrest(intrest);
	}

	public double getBedrag() {
		return bedrag;
	}

	public final void setBedrag(double bedrag) {
		if (bedrag <= MIN_BEDRAG)
			throw new IllegalArgumentException(String.format("Bedrag moet groter dan %.2f zijn!", MIN_BEDRAG));
		this.bedrag = bedrag;
	}

	public double getIntrest() {
		return intrest;
	}

	public final void setIntrest(double intrest) {
		if (intrest < MIN_INTREST || intrest > MAX_INTREST)
			throw new IllegalArgumentException(
					String.format("Intrest moet tussen %.2f & %.2f liggen!", MIN_INTREST, MAX_INTREST));
		this.intrest = intrest;
	}

	public double geefOpgebouwdKapitaal(int aantalJaar) {
		double resultaat;

		if (aantalJaar == 0)
			resultaat = this.bedrag;
		else
			resultaat = (1 + this.intrest / 100) * geefOpgebouwdKapitaal(aantalJaar - 1);

		return resultaat;

	}

}
