package testen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import domein.Bestelling;

public class BestellingTest {

	@Test // willekeurige waarde uit geldige partitie
	void maakBestelling_GeldigAantal_MaaktBestelling() {
		// Arrange
		int aantal = 5;
		// Act
		Bestelling b = new Bestelling(aantal);
		// Assert
		assertEquals(aantal, b.getAantal());
	}

	@Test // grenswaarde uit geldige partitie
	void maakBestelling_KleinstToegelatenAantal_MaaktBestelling() {
		assertEquals(1, new Bestelling(1).getAantal());
	}

	@Test // grenswaarde uit geldige partitie
	void maakBestelling_GrootstToegelatenAantal_MaaktBestelling() {
		assertEquals(10, new Bestelling(10).getAantal());
	}

	@Test // willekeurige waarde uit ongeldige partitie
	void maakBestelling_AantalTeKlein_WerptException() {
		assertThrows(IllegalArgumentException.class, () -> new Bestelling(-5));
	}

	@Test // willekeurige waarde uit ongeldige partitie
	void maakBestelling_AantalteGroot_WerptException() {
		assertThrows(IllegalArgumentException.class, () -> new Bestelling(20));
	}

	@Test // grenswaarde uit ongeldige partitie
	void maakBestelling_AantalIsNetTeKlein_WerptException() {
		assertThrows(IllegalArgumentException.class, () -> new Bestelling(0));
	}

	@Test // grenswaarde uit ongeldige partitie
	void maakBestelling_AantalIsNetTeGroot_WerptException() {
		assertThrows(IllegalArgumentException.class, () -> new Bestelling(11));
	}

	@Test
	void geeftRechtOpKorting_BestellingMetRechtOpKorting_RetourneertTrue() {
		Bestelling b = new Bestelling(7);
		assertTrue(b.geeftRechtOpKorting());
	}

	@Test
	void geeftRechtOpKorting_BestellingNetGrootGenoegVoorRechtOpKorting_RetourneertTrue() {
		Bestelling b = new Bestelling(5);
		assertTrue(b.geeftRechtOpKorting());
	}

	@Test
	void geeftRechtOpKorting_BestellingZonderRechtOpKorting_RetourneertFalse() {
		Bestelling b = new Bestelling(2);
		assertFalse(b.geeftRechtOpKorting());
	}

	@Test
	void geeftRechtOpKorting_BestellingNetNietGrootGenoegVoorRechtOpKorting_RetourneertFalse() {
		Bestelling b = new Bestelling(4);
		assertFalse(b.geeftRechtOpKorting());
	}

}
