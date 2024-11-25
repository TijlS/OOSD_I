package domein;

public class Rechthoek {
	private double lengte;
	private double breedte;
	private final static double DEFAULT_WAARDE = 1;

	public Rechthoek(double lengte, double breedte) {
		this.setLengte(lengte);
		this.setBreedte(breedte);
	}

	public Rechthoek() {
		this(10, 7);
	}

	public double getLengte() {
		return lengte;
	}

	public double getBreedte() {
		return breedte;
	}

	private void setLengte(double lengte) {
		if (lengte > 0)
			this.lengte = lengte;
		else
			this.lengte = DEFAULT_WAARDE;
	}

	private void setBreedte(double breedte) {
		if (breedte > 0)
			this.breedte = breedte;
		else
			this.breedte = DEFAULT_WAARDE;
	}
	
	public double berekenOppervlakte() {
		return lengte * breedte;
	}
	public double berekenOmtrek() {
		return (2*lengte) + (2*breedte);
	}

}
