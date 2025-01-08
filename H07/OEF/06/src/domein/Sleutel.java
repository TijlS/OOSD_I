package domein;

public class Sleutel extends Voorwerp {
	private static int aantalInOmloop;
	private int deur;

	public Sleutel(String naam, double gewicht, int niveau, int deur) {
		super(naam, gewicht, niveau);
		this.setDeur(deur);

		aantalInOmloop++;
	}

	public int getDeur() {
		return deur;
	}

	public void setDeur(int deur) {
		if (deur < 0)
			throw new IllegalArgumentException("Deur moet positief zijn!");

		this.deur = deur;
	}

	public static int getAantalInOmloop() {
		return aantalInOmloop;
	}

	public boolean pastOp(int deur) {
		return deur == this.deur;
	}

	@Override
	public String toString() {
		return String.format("%s past op deur %d", super.toString(), deur);
	}

}
