package domein;

import utils.Richting;

public class Rechthoek {
	private double lengte;
	private double breedte;
	private Coordinaat positie;

	public Rechthoek(double lengte, double breedte, Coordinaat positie) {
		setLengte(lengte);
		setBreedte(breedte);
		setPositie(positie);
	}

	public double geefOppervlakte() {
		return lengte * breedte;
	}

	public double geefOmtrek() {
		return 2 * (lengte + breedte);
	}

	public int geefXpos() {
		return positie.getX();
	}

	public int geefYpos() {
		return positie.getY();
	}

	public double getLengte() {
		return lengte;
	}

	public double getBreedte() {
		return breedte;
	}

	private void setLengte(double lengte) {
		if (lengte <= 0)
			throw new IllegalArgumentException("Lengte moet strikt positief zijn");
		this.lengte = lengte;
	}

	private void setBreedte(double breedte) {
		if (breedte <= 0)
			throw new IllegalArgumentException("Breedte moet strikt positief zijn");
		this.breedte = breedte;
	}

	private void setPositie(Coordinaat positie) {
		if (positie == null)
			throw new IllegalArgumentException("Een rechthoek moet een positie hebben");
		this.positie = positie;
	}

	public void verschuif(String richting) {
		positie.verplaats(Richting.valueOf(richting.toUpperCase()));
	}

	public void verschuif(String richting, int verschuiving) {
		positie.verplaats(Richting.valueOf(richting.toUpperCase()), verschuiving); // <1>
	}

	@Override
	public String toString() {
		return String.format("Rechthoek van %.2f op %.2f op coordinaat (%d, %d).", lengte, breedte, positie.getX(),
				positie.getY());
	}
}
