package domein;

public class Rechthoek {

	private double lengte;
	private double breedte;
	
	private static final int MIN_LENGTE_BREEDTE = 0;
	private static final int MIN_PERCENTAGE_SCHAAL = 1;
	private static final int MAX_PERCENTAGE_SCHAAL = 200;

	public Rechthoek(double lengte, double breedte) {
		setLengte(lengte);
		setBreedte(breedte);
	}

	public double geefOmtrek() {
		return 2 * (lengte + breedte);
	}

	public double geefOppervlakte() {
		return lengte * breedte;
	}

	public void schaal(int percentage) {
		if (percentage < MIN_PERCENTAGE_SCHAAL || percentage > MAX_PERCENTAGE_SCHAAL)
			throw new IllegalArgumentException(String.format(
					"Percentage om te schalen moet in interval [%d, %d] liggen", 
					MIN_PERCENTAGE_SCHAAL, 
					MAX_PERCENTAGE_SCHAAL
				));
		setLengte(lengte * percentage / 100);
		setBreedte(breedte * percentage / 100);
	}

	public double getLengte() {
		return this.lengte;
	}

	public double getBreedte() {
		return this.breedte;
	}

	private void setLengte(double lengte) {
		if (lengte <= MIN_LENGTE_BREEDTE)
			throw new IllegalArgumentException("Lengte moet strikt positief zijn");
		this.lengte = lengte;
	}

	private void setBreedte(double breedte) {
		if (breedte <= MIN_LENGTE_BREEDTE)
			throw new IllegalArgumentException("Breedte moet strikt positief zijn");
		this.breedte = breedte;
	}
}

/* ===== De klasse Rechthoek na code generatie uit VP ===== */
//public class Rechthoek {
//
//	private double lengte;
//	private double breedte;
//
//  private static final int MIN_LENGTE_BREEDTE = 0;
//  private static final int MIN_PERCENTAGE_SCHAAL = 1;
//  private static final int MAX_PERCENTAGE_SCHAAL = 200;
//
//	public Rechthoek(double lengte, double breedte) {
//		// TODO - implement Rechthoek.Rechthoek
//		throw new UnsupportedOperationException();
//	}
//
//	public double geefOmtrek() {
//		// TODO - implement Rechthoek.geefOmtrek
//		throw new UnsupportedOperationException();
//	}
//
//	public double geefOppervlakte() {
//		// TODO - implement Rechthoek.geefOppervlakte
//		throw new UnsupportedOperationException();
//	}
//
//	public void schaal(int percentage) {
//		// TODO - implement Rechthoek.schaal
//		throw new UnsupportedOperationException();
//	}
//
//	public double getLengte() {
//		return this.lengte;
//	}
//
//	public double getBreedte() {
//		return this.breedte;
//	}
//
//	private void setLengte(double lengte) {
//		this.lengte = lengte;
//	}
//
//	private void setBreedte(double breedte) {
//		this.breedte = breedte;
//	}
//}
