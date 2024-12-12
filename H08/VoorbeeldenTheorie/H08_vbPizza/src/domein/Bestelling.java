package domein;

public class Bestelling {
	private int aantal;
	
	private static final int MIN_AANTAL = 1; 
	private static final int MAX_AANTAL = 10;
	private static final int MIN_AANTAL_VOOR_KORTING = 5;

	public Bestelling(int aantal) {
		setAantal(aantal);
	}

	private void setAantal(int aantal) {
		if (aantal < MIN_AANTAL || aantal > MAX_AANTAL)
			throw new IllegalArgumentException(String.format("Het aantal moet tussen %d en %d liggen", MIN_AANTAL, MAX_AANTAL));
		this.aantal = aantal;
	}

	public int getAantal() {
		return aantal;
	}

	public boolean geeftRechtOpKorting() {
		return aantal >= MIN_AANTAL_VOOR_KORTING;
	}
}
