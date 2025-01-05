package testen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Categorie;
import domein.Snack;

class SnackTesten {

	@ParameterizedTest
	@ValueSource(strings = { "abc", "a bc", "  a" })
	void maakSnack_GeldigeNaam_MaaktSnack(String naam) {
		Snack s = new Snack(naam, Categorie.FRUIT);
		assertEquals(naam, s.getNaam());
		assertEquals(Categorie.FRUIT, s.getCategorie());
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { "  " })
	void maakSnack_OngeldigeNaam_WerptException(String naam) {
		assertThrows(IllegalArgumentException.class, () -> new Snack(naam, Categorie.FRUIT));
	}

	@Test
	void maakSnack_CategorieNietIngevuld_WerptException() {
		assertThrows(IllegalArgumentException.class, () -> new Snack("Appel", null));
	}

	@Test
	void isGezond_GezondeSnack_RetourneertTrue() {
		assertTrue(new Snack("Wortel", Categorie.GROENTE).isGezond());
		assertTrue(new Snack("Appel", Categorie.FRUIT).isGezond());
	}

	@Test
	void isGezond_OngezondeSnack_RetourneertFalse() {
		assertFalse(new Snack("M&M", Categorie.SNOEP).isGezond());
	}

}
