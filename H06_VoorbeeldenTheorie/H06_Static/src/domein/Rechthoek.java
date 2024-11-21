package domein;

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
		this.lengte = lengte;
	}

	private void setBreedte(double breedte) {
		this.breedte = breedte;
	}

	private void setPositie(Coordinaat positie) {
		this.positie = new Coordinaat(positie.getX(), positie.getY());
	}

	public void verschuif(String richting) {
		positie.verplaats(richting);
	}

	public void verschuif(String richting, int verschuiving) {
		positie.verplaats(richting, verschuiving);
	}

	// Deze methode is enkel ter demonstratie maar maakt verder geen deel uit
	// van het ontwerp van deze klasse.
	public void wijzigParameters(double parLengte, double parBreedte, Coordinaat parCoordinaat) {
		parLengte = 100;
		parBreedte = 100;
		parCoordinaat.verplaats("boven", 97);
		parCoordinaat.verplaats("rechts", 97);
	}

	@Override
	public String toString() {
		return String.format("Rechthoek van %.2f op %.2f op coordinaat (%d, %d).", lengte, breedte, positie.getX(),
				positie.getY());
	}
}
