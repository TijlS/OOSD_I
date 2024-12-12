package testen;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Kluis;

class KluisTest {
	@Test
	void maakKluis_GeenCode_WerptException() {
		// arrange
		String ongeldigeCode = null;
		// act && assert
		assertThrows(IllegalArgumentException.class, () -> new Kluis(ongeldigeCode));
	}

	@Test
	void maakKluis_CodeIsTeKort_WerptException() {
		// arrange
		String ongeldigeCode = "1";
		// act && assert
		assertThrows(IllegalArgumentException.class, () -> new Kluis(ongeldigeCode));
	}

	@Test
	void maakKluis_CodeIsNetTeKort_WerptException() {
		// arrange
		String ongeldigeCode = "123";
		// act && assert
		assertThrows(IllegalArgumentException.class, () -> new Kluis(ongeldigeCode));
	}

	@Test
	void maakKluis_CodeIsTeLang_WerptException() {
		// arrange
		String ongeldigeCode = "1234567";
		// act && assert
		assertThrows(IllegalArgumentException.class, () -> new Kluis(ongeldigeCode));
	}

	@Test
	void maakKluis_CodeIsNetTeLang_WerptException() {
		// arrange
		String ongeldigeCode = "12345";
		// act && assert
		assertThrows(IllegalArgumentException.class, () -> new Kluis(ongeldigeCode));
	}

	@Test
	void maakKluis_CodeBevatEenTekenDatGeenCijferIs_WerptException() {
		// arrange
		String ongeldigeCode = "12A3";
		// act && assert
		assertThrows(IllegalArgumentException.class, () -> new Kluis(ongeldigeCode));
	}

	@Test
	void maakKluis_CodeBestaatUit4GelijkeCijfers_WerptException() {
		// arrange
		String ongeldigeCode = "3333";
		// act && assert
		assertThrows(IllegalArgumentException.class, () -> new Kluis(ongeldigeCode));
	}

	@Test
	void maakKluis_CodeBestaatUitNetGeen4GelijkeCijfers_MaaktKluis() {
		// arrange
		String geldigeCode = "3133";
		// act & assert
		assertDoesNotThrow( () -> new Kluis(geldigeCode));
	}

	@Test
	void valideer_CodesKomenOvereen_RetourneertTrue() {
		// arrange
		String geldigeCode = "3133";
		Kluis kluis = new Kluis(geldigeCode);
		// act
		boolean resultaat = kluis.valideerCode(geldigeCode);
		// assert
		assertTrue(resultaat);
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { "1222", "1286" })
	void valideer_CodesVerschillen_RetourneertFalse(String code) {
		// arrange
		String geldigeCode = "1285";
		Kluis kluis = new Kluis(geldigeCode);
		// act
		boolean resultaat = kluis.valideerCode(code);
		// assert
		assertFalse(resultaat);
	}
}