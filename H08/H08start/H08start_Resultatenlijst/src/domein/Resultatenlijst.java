package domein;

import java.util.List;

public class Resultatenlijst {
	public static final int MIN_RESULTAAT = 0;
	public static final int MAX_RESULTAAT = 20;
	public static final int MAX_AANTAL_RESULTATEN = 5;

	private List<Integer> resultaten;

	/**
	 * Class constructor. Een nieuwe <code>Resultatenlijst</code> bevat een lijst
	 * met 0 resultaten.
	 * 
	 */
	public Resultatenlijst() {
		// TODO - implement Resultatenlijst
		throw new UnsupportedOperationException();
	}

	/**
	 * Voegt een resultaat toe aan de lijst van resultaten<br>
	 * - het resultaat moet in het interval [0, 20] liggen <br>
	 * - een resultatenlijst kan niet meer dan 5 bevatten
	 * 
	 * @throws IllegalArgumentException wanneer het resultaat niet voldoet of
	 *                                  wanneer de lijst reeds 5 resultaten bevat
	 */
	public void voegResultaatToe(int resultaat) {
		// TODO - implement voegResultaatToe
		throw new UnsupportedOperationException();
	}

	public List<Integer> getResultaten() {
		return resultaten;
	}

	/**
	 * @return het gemiddelde van alle resultaten tot op 1/1000 nauwkeurig
	 * @throws IllegalArgumentException wanneer er geen resultaten zijn
	 */
	public double geefGemiddelde() {
		// TODO - implement geefGemiddelde
		throw new UnsupportedOperationException();
	}
}
