package domein;

public class VerplaatsingPerBusTram extends Verplaatsing {
	private static final double PRIJS_PER_HALTE = 0.32;

	private int lijnnr;
	private boolean bus;
	private boolean stadslijn;

	public VerplaatsingPerBusTram(String van, String naar, double aantalKm, int lijnnr, boolean bus,
			boolean stadslijn) {
		super(van, naar, aantalKm);
		this.setLijnnr(lijnnr);
		this.setBus(bus);
		this.setStadslijn(stadslijn);
	}

	public int getLijnnr() {
		return lijnnr;
	}

	public void setLijnnr(int lijnnr) {
		if (lijnnr <= 0)
			throw new IllegalArgumentException("Lijnnr moet strikt positief zijn!");
		this.lijnnr = lijnnr;
	}

	public boolean isBus() {
		return bus;
	}

	public boolean isStadslijn() {
		return stadslijn;
	}

	private void setBus(boolean bus) {
		this.bus = bus;
	}

	private void setStadslijn(boolean stadslijn) {
		this.stadslijn = stadslijn;
	}

	@Override
	public String toString() {
		return String.format("%s met %s%s %d", super.toString(), stadslijn ? "stads" : "", bus ? "bus" : "tram",
				stadslijn);
	}

	public double berekenPrijs() {
		double aantalHaltes = Math.ceil(super.getAantalKm());

		double prijs = 2 * aantalHaltes * PRIJS_PER_HALTE;

		return isStadslijn() ? prijs * 0.8 : prijs;
	}
}
