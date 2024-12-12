package testen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Bestelling;

public class BestellingTest_Parameterized {

	@ParameterizedTest // geldige waarden
	@ValueSource(ints = { 5, 1, 10 })
	void maakBestelling_GeldigAantal_maaktBestelling(int aantal) {
		assertEquals(aantal, new Bestelling(aantal).getAantal());
	}

	@ParameterizedTest // ongeldige waarden
	@ValueSource(ints = { -5, 20, 0, 11 })
	void maakBestelling_OngeldigAantal_werptException(int aantal) {
		assertThrows(IllegalArgumentException.class, () -> new Bestelling(aantal));
	}

	@ParameterizedTest
	@ValueSource(ints = { 5, 7 })
	void geeftRechtOpKorting_BestellingMetRechtOpKorting_RetourneertTrue(int aantal) {
		Bestelling b = new Bestelling(aantal);
		assertTrue(b.geeftRechtOpKorting());
	}

	@ParameterizedTest
	@ValueSource(ints = { 2, 4 })
	void geeftRechtOpKorting_BestellingZonderRechtOpKorting_RetourneertFalse(int aantal) {
		Bestelling b = new Bestelling(aantal);
		assertFalse(b.geeftRechtOpKorting());
	}

}
