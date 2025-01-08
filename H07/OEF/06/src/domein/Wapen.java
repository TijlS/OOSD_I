package domein;

public class Wapen extends Voorwerp {
	private static final int MAX_NIVEAU = 5;
	private int kracht;
	private boolean gebruikt;

	public Wapen(String naam, double gewicht, int niveau, int kracht, boolean gebruikt) {
		super(naam, gewicht, niveau);

		controleerNiveau(niveau);
		this.setKracht(kracht);
		this.setGebruikt(gebruikt);
	}

	private void controleerNiveau(int niveau) {
		if (niveau > MAX_NIVEAU)
			throw new IllegalArgumentException(String.format("Niveau mag max %d zijn!", MAX_NIVEAU));
	}

	public int getKracht() {
		return kracht;
	}

	public void setKracht(int kracht) {
		if (kracht < 0)
			throw new IllegalArgumentException("Kracht moet positief zijn!");
		this.kracht = kracht;
	}

	public void setGebruikt(boolean gebruikt) {
		this.gebruikt = gebruikt;
	}

	public boolean isGebruikt() {
		return this.gebruikt;
	}

	@Override
	public String toString() {
		return String.format("%s en met kracht %d %s gebruikt.", super.toString(), kracht,
				gebruikt ? "al" : "nog niet");
	}

}
