package testen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Bestelling;

class BestellingTest_MetPrivateMethodeEnAttributen {
	
	private Bestelling b;
	
	private static final int MIN_AANTAL = 1; 
	private static final int MAX_AANTAL = 10;
	private static final int MIN_AANTAL_VOOR_KORTING = 5;
	
	private void maakBestellingMetAantal(int aantal) {
		b = new Bestelling (aantal);
	}

	@ParameterizedTest // geldige waarden
	@ValueSource(ints = { 5, MIN_AANTAL, MAX_AANTAL })
	void maakBestelling_GeldigAantal_maaktBestelling(int aantal) {
		assertEquals(aantal, new Bestelling(aantal).getAantal());
	}

	@ParameterizedTest // ongeldige waarden
	@ValueSource(ints = { -5, 20, MIN_AANTAL-1, MAX_AANTAL+1 })
	void maakBestelling_OngeldigAantal_werptException(int aantal) {
		assertThrows(IllegalArgumentException.class, () -> new Bestelling(aantal));
	}

	@ParameterizedTest
	@ValueSource(ints = { MIN_AANTAL_VOOR_KORTING, 7 })
	void geeftRechtOpKorting_BestellingMetRechtOpKorting_RetourneertTrue(int aantal) {
		maakBestellingMetAantal(aantal);
		assertTrue(b.geeftRechtOpKorting());
	}

	@ParameterizedTest
	@ValueSource(ints = { 2, MIN_AANTAL_VOOR_KORTING-1 })
	void geeftRechtOpKorting_BestellingZonderRechtOpKorting_RetourneertFalse(int aantal) {
		maakBestellingMetAantal(aantal);
		assertFalse(b.geeftRechtOpKorting());
	}
}
