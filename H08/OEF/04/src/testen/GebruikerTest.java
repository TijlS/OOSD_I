package testen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Gebruiker;

class GebruikerTest {

	private final static String GELDIGE_NAAM = "AB.CDEF";
	private final static double GELDIG_KREDIET = 50.5;

	/**
	 * Gebruikersnaam: <br>
	 * LENGTE: <br>
	 * - 4, 5, 6, 10 <br>
	 * #PUNTEN: <br>
	 * - 0, 1, 8 <br>
	 * BEGINT MET PUNT: <br>
	 * - true, false <br>
	 * EINDIGT MET PUNT: <br>
	 * - true, false <br>
	 * AANTAL SPATIES: <br>
	 * - 0, 1 <br>
	 */

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { "A  B.DE", "A B.CDEF", ".ABCDE.F", "ABCD.EF.", "AB.D", "AB.DE", "ABCDEF" })
	void maakGebruiker_OngeldigeGebruikersnaam_WerptException(String ongeldigeGebruikersnaam) {
		assertThrows(IllegalArgumentException.class, () -> new Gebruiker(ongeldigeGebruikersnaam, GELDIG_KREDIET));
	}

	@ParameterizedTest
	@ValueSource(strings = { "A.CABCABCABCA", "AB.ABC", "A.........B" })
	void maakGebruiker_GeldigeGebruikersnaamEnGeldigKrediet_MaaktGebruiker(String geldigeGebruikersnaam) {
		Gebruiker geb = new Gebruiker(geldigeGebruikersnaam, GELDIG_KREDIET);

		assertEquals(geldigeGebruikersnaam, geb.getGebruikersnaam());
		assertEquals(GELDIG_KREDIET, geb.getKrediet());
	}

	/**
	 * Krediet: <br>
	 * - ONGELDIG: 0.01, 50, 100<br>
	 * - GELDIG: -5, 0, 100.01, 105
	 */

	@ParameterizedTest
	@ValueSource(doubles = { -5, 0, 100.01, 105 })
	void maakGebruiker_GeldigeGebruikersnaamEnOngeldigKrediet_WerptException(double krediet) {
		assertThrows(IllegalArgumentException.class, () -> new Gebruiker(GELDIGE_NAAM, krediet));
	}

	@ParameterizedTest
	@ValueSource(doubles = { 0.01, GELDIG_KREDIET, 100 })
	void maakGebruiker_GeldigeGebruikersnaamEnGeldigKrediet_MaaktGebruiker(double krediet) {
		Gebruiker geb = new Gebruiker(GELDIGE_NAAM, krediet);

		assertEquals(GELDIGE_NAAM, geb.getGebruikersnaam());
		assertEquals(krediet, geb.getKrediet());
	}

}
